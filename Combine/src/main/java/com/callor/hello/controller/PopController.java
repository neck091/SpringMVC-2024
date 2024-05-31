package com.callor.hello.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.callor.hello.service.PopService;

@RestController
public class PopController {

    @Autowired
    private PopService popService;

    @GetMapping("/api/scrapeWords")
    public List<String> scrapeWords(@RequestParam String word) {
        return popService.scrapeWords(word);
    }
}
