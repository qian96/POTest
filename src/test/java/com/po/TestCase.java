package com.po;

import com.alibaba.fastjson.JSONArray;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Author wangqian
 * @Date 2020-12-01 14:45
 * @Version 1.0
 */
public class TestCase {
   public List<String> data;
   public List<HashMap<String,Object>> steps;
   public int index=0;


   //封装step.get
   public Object getValue(HashMap<String,Object> step,String key){
      //传参数，如果值是string类型，进行替换
      Object value = step.get(key);
      if (value instanceof String){
         return ((String)value).replace("${data}",data.get(index));
      }else {
         return value;
      }
   }
   //取出data中的值
   public List<TestCase>  testCaseGenerate(){
      List<TestCase> testCaseList = new ArrayList<>();
      for (int i = 0; i < data.size(); i++) {
         TestCase testCase = new TestCase();
         testCase.index=i;
         testCase.steps=steps;
         testCase.data=data;
         testCaseList.add(testCase);
      }
      return testCaseList;
   }

   //封装step.get带参数
   public Object getValue(HashMap<String,Object> step,String key,Object defalutValue){
      return step.getOrDefault(key,defalutValue);
   }
  public void run(){}
}
