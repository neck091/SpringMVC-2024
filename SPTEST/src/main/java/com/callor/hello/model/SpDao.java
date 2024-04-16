package com.callor.hello.model;

import org.openkoreantext.processor.tokenizer.KoreanTokenizer;
import org.openkoreantext.processor.tokenizer.KoreanTokenizer.KoreanToken;

import scala.collection.Seq;

public class SpDao { 
	   public Seq<KoreanToken> analyzeText(String text) {
	        CharSequence charSequence = text; // String을 CharSequence로 명시적으로 변환
	        Seq<KoreanToken> result = KoreanTokenizer.tokenize(charSequence, null);
	        return result;
	    }
}