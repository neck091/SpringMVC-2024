package com.callor.hello;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    private WebDriver driver;

    public HomeController() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/KMS505102/Documents/workspace/SpringMVC/SP/document/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @RequestMapping("/")
    public String home() {
        return "index";
    }

    @PostMapping("/correct")
    public String correctText(@RequestParam("text") String text, Model model) {
        String correctedText = correctIt(text);
        model.addAttribute("correctedText", correctedText);
        return "index";
    }

    private String correctIt(String source) {
        String correctedText = "";

        try {
            driver.get(
                    "https://search.naver.com/search.naver?where=nexearch&query=%EB%84%A4%EC%9D%B4%EB%B2%84+%EB%A7%9E%EC%B6%A4%EB%B2%95+%EA%B2%80%EC%82%AC%EA%B8%B0&ie=utf8&sm=tab_she&qdt=0");
        	driver.findElement(By.cssSelector(
    				"#grammar_checker > div.check_box > div.text_box._original > div > div.text_area > textarea")).clear();//글쓰기 영역을 깨끗이 지운다.
    		driver.findElement(By.cssSelector(
    				"#grammar_checker > div.check_box > div.text_box._original > div > div.text_area > textarea"))
    				.sendKeys(source); //엑셀에 작성한 내용(source)를 글쓰기 영역에 붙여넣는다.
    		driver.findElement(By.cssSelector(
    				"#grammar_checker > div.check_box > div.text_box._original > div > div.check_info > button")).click(); //검사하기 버튼을 누른다.
    		wait(8); //0.8초 대기

    		return driver
    				.findElement(By.cssSelector(
    						"#grammar_checker > div.check_box > div.text_box.right._result.result > div > div.text_area"))
    				.getText().replace("맞춤법검사기 결과 영역", ""); 
        } catch (Exception e) {
            e.printStackTrace();
        }

        return correctedText;
    }
}