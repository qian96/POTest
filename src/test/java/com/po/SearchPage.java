package com.po;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @Author wangqian
 * @Date 2020-12-01 15:37
 * @Version 1.0
 */
public class SearchPage extends BasePage {
    public SearchPage(WebDriver driver) {
        super(driver);
    }
    public void search(String keyword){
        click(By.id("search-button"));
        sendKeys(By.id("search-term"),keyword);
    }
}
