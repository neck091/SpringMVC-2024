package com.callor.hello;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.callor.hello.service.KoreanNLPService;

@Controller
@RequestMapping(value="/test")
public class KoreanNLPController {

    private final KoreanNLPService koreanNLPService;

    @Autowired
    public KoreanNLPController(KoreanNLPService koreanNLPService) {
        this.koreanNLPService = koreanNLPService;
    }

    @RequestMapping(value="/input" ,method=RequestMethod.GET)
    public String showForm() {
        return "inputForm"; // 입력 폼 템플릿을 표시합니다.
    }

    @RequestMapping(value="/analyzeText", method=RequestMethod.POST)
	public String analyzeText(@RequestParam("text") String text, HttpServletRequest request) {
	    String analysisResult = koreanNLPService.analyzeText(text);
	    request.setAttribute("analysisResult", analysisResult);
	    return "analysisResult"; // 분석 결과를 표시하는 JSP 페이지로 포워딩합니다.
	}
}