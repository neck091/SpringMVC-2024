package com.callor.hello;

import java.io.IOException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.hello.service.PopService;
import com.callor.hello.service.SpService;

import lombok.extern.slf4j.Slf4j;
/**
 * Handles requests for the application home page.
 */
@Slf4j
@Controller
public class HomeController {

    private final SpService spService;
    private final PopService popService;
    

    public HomeController(SpService spService, PopService popService) {
		super();
		this.spService = spService;
		this.popService = popService;
	}

	@RequestMapping(value="/", method=RequestMethod.GET)
    public String showForm() {
        return "form"; // form.html로 이동
    }

    @RequestMapping(value="/noun", method=RequestMethod.GET)
    public String extractNouns(String text, Model model) {
    	log.debug("한글: {}", text);
    	model.addAttribute("nouns", spService.extractNouns(text));
        return "form";
    }
    

    @RequestMapping(value="/words", method=RequestMethod.GET)
    public String showWords(String word, Model model) throws IOException {
        List<String> words = popService.scrapeWords(word);
        model.addAttribute("words", words);
        return "words";
    }
  
}