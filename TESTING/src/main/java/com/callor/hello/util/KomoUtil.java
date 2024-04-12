package com.callor.hello.util;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.co.shineware.nlp.komoran.core.Komoran;
import kr.co.shineware.nlp.komoran.model.Token;

@Service
public class KomoUtil {

    private final Komoran komoran;

    public KomoUtil() {
        this.komoran = new Komoran("models");
    }

    public String analyzeText(String text) {
        List<Token> tokens = komoran.analyze(text).getTokenList();

        StringBuilder result = new StringBuilder();
        for (Token token : tokens) {
            result.append(token.getPos()).append(": ").append(token.getMorph()).append("<br>");
        }

        return result.toString();
    }
}