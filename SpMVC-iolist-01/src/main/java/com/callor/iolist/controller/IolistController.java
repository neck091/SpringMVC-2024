package com.callor.iolist.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.iolist.models.IolistVO;
import com.callor.iolist.models.UserVO;
import com.callor.iolist.persistance.IolistDao;
import com.callor.iolist.utils.NamesValue;

@Controller
@RequestMapping(value = "/iolist")
public class IolistController {

	private final IolistDao iolistDao;

	public IolistController(IolistDao iolistDao) {
		this.iolistDao = iolistDao;
	}

	@RequestMapping(value = { "/", "" }, method = RequestMethod.GET)
	public String home(Model model) {
		
		model.addAttribute("BODY", "IOLIST_HOME");
		List<IolistVO> iolist = iolistDao.selectAll();
		model.addAttribute("IOLIST", iolist);
		return "layout";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String insert(Model model, HttpSession httpSession) {
		
		/***
		 * 오브젝트 형변환
		 */
		UserVO userVO = (UserVO) httpSession.getAttribute(NamesValue.SESSION.USER);
		
		if(userVO==null) {
			return "redirect:/user/login?error=needs";
		}
		
		Date today = new Date();
		Calendar ca = Calendar.getInstance();
		
		//자바 1.8 이상에서 사용하는 클래스
		LocalDate localdate = LocalDate.now();
		LocalDate localTime = LocalDate.now();
		LocalDateTime localDateTime = LocalDateTime.now();
		
		DateTimeFormatter dayFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm:ss");
		
		
		/**
		 * Builder pattern 을 사용하면 
		 * 필요한 필드에 값만 세팅하면서 객체 생성 가능
		 */
		IolistVO vo= IolistVO.builder()
			.io_date(localDateTime.format(dayFormat))			
			.io_time(localDateTime.format(timeFormat))
				.build();
		
//
//		IolistVO vo = new IolistVO();
//		vo.setIo_date(localDateTime.format(dayFormat));
//		vo.setIo_time(localDateTime.format(dayFormat));
//		
		model.addAttribute("IO",vo);
		model.addAttribute("BODY", "IOLIST_INPUT");
		return "layout";
		
	}

	
	/**
	 * POST/insert와 POST/update로 들어온 걸 모두 처리함
	 */
	@RequestMapping(value = {"/insert","/update/{seq}"}, method = RequestMethod.POST)
	public String insertOrUpdate(@PathVariable(name="seq",required= false,value="") 
	String seq, IolistVO iolistVO, Model model) {
		
		
		if(seq != null) {
			iolistVO.setIo_seq(Long.valueOf(seq));
			
		}
		
		int result = iolistDao.insertOrUpdate(iolistVO);
		if (result > 0) {
			return "redirect:/iolist/";
		} else {
			model.addAttribute("BODY", "IOLIST_INPUT");
			return "layout";

		}

	}
	@RequestMapping(value="/detail/{seq}", method=RequestMethod.GET)
	public String detail(@PathVariable("seq") String seq, Model model ) {
		Long io_seq = Long.valueOf(seq);
		IolistVO vo = iolistDao.findBySeq(io_seq);
		
		model.addAttribute("IO",vo);
		
		model.addAttribute("BODY", "IOLIST_DETAIL");
		return "layout";
		
	}
	
	@RequestMapping(value="/update/{seq}", method=RequestMethod.GET)
	public String update(@PathVariable("seq") String seq, Model model) {
		
		
		Long io_seq= Long.valueOf(seq);
		IolistVO vo = iolistDao.findBySeq(io_seq);
		model.addAttribute("IO",vo);
		model.addAttribute("BODY","IOLIST_INPUT");
		return "layout";
		
	}
	
	@RequestMapping(value="/delete/{seq}", method=RequestMethod.GET)
	public String delete(@PathVariable("seq") String seq, Model model) {
		Long io_seq =Long.valueOf(seq);
		int ret = iolistDao.delete(io_seq);
		return "redirect:/iolist";
	}

}
