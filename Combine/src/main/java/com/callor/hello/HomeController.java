package com.callor.hello;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.callor.hello.service.CheckService;
import com.callor.hello.service.PopService;
import com.callor.hello.service.SpService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

/**
 * Handles requests for the application home page.
 */
@Slf4j
@Controller
public class HomeController {

	private final SpService spService;
	private final PopService popService;
	private final CheckService checkService;


	public HomeController(SpService spService, PopService popService, CheckService checkService) {
		super();
		this.spService = spService;
		this.popService = popService;
		this.checkService = checkService;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String extractNouns(@RequestParam(required = false, defaultValue = "") String text, Model model) {
		log.debug("한글: {}", text);
		model.addAttribute("nouns", spService.extractNouns(text));
		model.addAttribute("texts", text);
		return "form";
	}

	@RequestMapping(value = "/words", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String showWords(String word) throws IOException {
		List<String> words = popService.scrapeWords(word);

		// ObjectMapper를 사용하여 리스트를 JSON 형식의 문자열로 변환
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonWords = null;
		try {
			jsonWords = objectMapper.writeValueAsString(words);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		return jsonWords;
	}
	

	@RequestMapping(value = "/check", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public String check(String inputText, Model model) {
        String result = checkService.checkGrammar(inputText); // 서비스를 통해 맞춤법 검사 결과 가져오기

        return result; // 결과 페이지 js에 전달
    }	
}