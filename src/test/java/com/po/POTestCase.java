package com.po;

import com.alibaba.fastjson.JSONArray;

import java.util.ArrayList;

/**
 * @Author wangqian
 * @Date 2020-12-02 15:40
 * @Version 1.0
 */
public class POTestCase extends TestCase{

    @Override
    public void run(){
        steps.forEach(step -> {
            String key = step.keySet().iterator().next();

            if(key.contains("init")){
                ArrayList<String> value = (ArrayList<String>) getValue(step, "init");
                BasePage.getInstance().poInt(value.get(0),value.get(1));
            }

            if(key.contains(".")){
                String[] objectMethod = key.split("\\.");
                String object = objectMethod[0];
                String method = objectMethod[1];

                // mainPage.stepRun(method);
                BasePage.getInstance().getPO(object).stepRun(method);

            }
        });

    }

}
