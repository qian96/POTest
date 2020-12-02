package com.po;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * @Author wangqian
 * @Date 2020-12-01 15:36
 * @Version 1.0
 */
public class MainPage extends BasePage {
    public MainPage(WebDriver driver) {
        super(driver);
    }

    public MainPage(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://ceshiren.com");
    }
    public SearchPage search(){
        return new SearchPage(driver);
    }

}
