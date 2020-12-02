package com.po;

import com.google.gson.JsonElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @Author wangqian
 * @Date 2020-12-01 15:35
 * @Version 1.0
 */
public class BasePage {
    static BasePage instance=null;
    WebDriver driver;
    HashMap<String,BasePage> pages = new HashMap<>();

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }
    public BasePage() { }

    void click(By by){
        driver.findElement(by).click();
    }
    void sendKeys(By by,String content){
        driver.findElement(by).sendKeys(content);
    }

    public static BasePage getInstance(){
        if(instance == null){
            instance = new BasePage();
        }
        return instance;
    }
    //使用反射获取类名
    void poInt(String name, String className){
        try {
            BasePage pageClass = (BasePage) Class.forName(className).getDeclaringClass().newInstance();
            pages.put( name,pageClass);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    //返回类名
    BasePage getPO(String name){
        return pages.get(name);
    }

    //使用反射获取类中的方法
    void stepRun(String method){
        Method method1 =Arrays.stream(this.getClass().getMethods())
        .filter(m->m.getName().equals(method))
                .findFirst().get();
        try {
            method1.invoke(this);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
