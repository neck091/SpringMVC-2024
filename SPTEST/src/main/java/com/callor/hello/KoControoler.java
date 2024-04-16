package com.callor.hello;

import java.util.List;
import java.util.StringJoiner;

import org.openkoreantext.processor.tokenizer.Sentence;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class KoControoler {

	@PostMapping("/process")
	public ModelAndView processNaturalLanguage(@RequestParam("inputText") String inputText, Model model) {
		// KoNLPy의 Okt 형태소 분석기를 사용하여 한글 텍스트를 형태소 분석하고 명사를 추출합니다.
		Okkachi okt = new OkkachiWrapper();
		List<Sentence> sentences = okt.analyze(inputText);

		// 추출된 명사 리스트를 결과 페이지에 전달합니다.
		StringJoiner result = new StringJoiner(", ");
		for (Sentence sentence : sentences) {
			result.add(sentence.stream().filter(token -> token.getTag().toString().startsWith("N"))
					.map(token -> token.getSurface()).reduce((a, b) -> a + " " + b).orElse(""));
		}
		model.addAttribute("nouns", result.toString());

		return new ModelAndView("resultPage");
	}
}