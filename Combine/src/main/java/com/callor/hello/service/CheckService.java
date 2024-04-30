package com.callor.hello.service;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.stereotype.Service;

@Service
public class CheckService {
	

    public String checkGrammar(String sentence) {
        // Chrome 드라이버 경로 설정
        System.setProperty("webdriver.chrome.driver", "path_to_chromedriver/chromedriver");

        // Chrome 브라우저 열기
        WebDriver driver = new ChromeDriver();

        try {
            // 다음 맞춤법 검사기 페이지로 이동
            driver.get("https://alldic.daum.net/grammar_checker.do");

            // 문장 입력 필드 찾기
            WebElement inputField = driver.findElement(By.cssSelector("textarea#txt_input"));

            // 문장 입력
            inputField.sendKeys(sentence);

            // 검사 버튼 클릭
            WebElement checkButton = driver.findElement(By.cssSelector("button#btn_check"));
            checkButton.click();

            // 결과 가져오기 (결과가 로딩될 때까지 충분한 시간을 주는 것이 좋음)
            Thread.sleep(5000); // 예시로 5초 대기
            WebElement resultElement = driver.findElement(By.cssSelector("div.wrap_result"));

            // 결과 텍스트 추출
            String result = resultElement.getText();

            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return "Error occurred while checking grammar.";
        } finally {
            // 브라우저 닫기
            driver.quit();
        }
    }
	
}
