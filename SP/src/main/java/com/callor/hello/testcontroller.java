package com.callor.hello;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.shineware.nlp.komoran.constant.DEFAULT_MODEL;
import kr.co.shineware.nlp.komoran.core.Komoran;
import kr.co.shineware.nlp.komoran.model.KomoranResult;

@Controller
public class testcontroller {

    @PostMapping("/extract-nouns")
    public String extractNouns(@RequestParam("sentence") String sentence, Model model) {
        Komoran komoran = new Komoran(DEFAULT_MODEL.FULL);
        KomoranResult result = komoran.analyze(sentence);
        List<String> nouns = result.getNouns();
        model.addAttribute("nouns", nouns);
        return "nouns";
    }
}