package com.callor.iolist;

import java.util.List;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.callor.iolist.model.IoVO;
import com.callor.iolist.persistance.IoDao;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private final IoDao ioDao;
	
	public HomeController(IoDao ioDao) {
		this.ioDao = ioDao;
		
	}
	

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		
		List<IoVO> ioList = ioDao.selectAll();
		model.addAttribute("IO_LIST", ioList);
		return "io/list";

	}
	

	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String insert() {
		return "io/input";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(IoVO vo, Model model) {
		try {
			int result = ioDao.insert(vo);

			if (result > 0) {

				return "redirect:/";

			} else {
				model.addAttribute("MSG", "INSERT ERROR");
				return "io/input";
			}

		} catch (Exception e) {
			model.addAttribute("MSG", "SQL ERROR");
			return "io/input";
		}

	}


	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String detail(@RequestParam("seq") String seq, Model model, 
			@RequestParam(name="msg", required=false, defaultValue = "OK") String msg) {
		IoVO ioVO = ioDao.findByID(seq);
		model.addAttribute("IO", ioVO);
		model.addAttribute("MSG", msg);
		return "io/detail";

	}

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String update(@RequestParam("seq") String ioSeq, Model model) {
		IoVO ioVO = ioDao.findByID(ioSeq);
		model.addAttribute("IO", ioVO);
	
		return "io/input";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(IoVO ioVO) {
		int result = ioDao.update(ioVO);
		String retString = String.format("redirect:/detail?seq=%s", ioVO.getSeq());
//		return retString;
		return "redirect:/detail?seq=" + ioVO.getSeq();
	}

	
	@RequestMapping(value = "/delete/{ioseq}", method = RequestMethod.GET)
	public String delete(@PathVariable("ioseq") String ioSeq) {
		int result = 0;
		try {
			result = ioDao.delete(ioSeq);

		} catch (Exception e) {
			return "redirect:/detail?seq=" + ioSeq + "&msg=FK";

		}

		if (result > 0) {
			return "redirect:/";
		} else {
			return "redirect:/detail?seq=" + ioSeq + "&msg=NOT";
		}
	}



}

	

