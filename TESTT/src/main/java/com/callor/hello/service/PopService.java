package com.callor.hello.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PopService {
	public List<String> scrapeWords(String word) throws IOException {
		// 선택한 단어를 이용하여 기본 URL에 추가
		String baseUrl = "https://ko.wiktionary.org/wiki/";
		String url = baseUrl + word;

		log.debug(url);
		List<String> words = new ArrayList<>();

		// Jsoup을 사용하여 HTML 문서를 가져옵니다.
		Document doc = Jsoup.connect(url).get();

		// li 태그들을 모두 찾습니다.
		Elements liTags = doc.select("li");

		// 각 li 태그에서 유의어 부분을 찾아냅니다.
		for (Element li : liTags) {
			String text = li.text();
			if (text.contains("유의어")) {
				String[] synonyms = text.split(":")[1].trim().split(", ");
				for (String synonym : synonyms) {
					words.add(synonym);
				}
			}
		}

		log.debug("리스트 {}", words);
		return words;
	}
}
