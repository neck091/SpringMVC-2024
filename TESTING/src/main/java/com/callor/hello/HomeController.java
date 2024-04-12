package com.callor.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.hello.service.KoreanNLPService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HomeController {

    @Autowired
    private KoreanNLPService koreanNLPService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        return "inputForm"; // inputForm.jsp로 이동
    }

    @PostMapping("/analyzeText")
    public String analyzeText(HttpServletRequest request, Model model) {
        String text = request.getParameter("text");
        String analysisResult = koreanNLPService.analyzeText(text);
        model.addAttribute("analysisResult", analysisResult);
        return "analysisResult"; // analysisResult.jsp로 이동
    }
}