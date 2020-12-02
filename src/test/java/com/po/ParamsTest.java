package com.po;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.List;

/**
 * @Author wangqian
 * @Date 2020-12-02 15:14
 * @Version 1.0
 */
public class ParamsTest {


    @ParameterizedTest
    @MethodSource
    void search(TestCase testCase){
        System.out.println(testCase);
        testCase.run();
    }
    static List<TestCase> search() throws IOException {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        TestCase testCase = mapper.readValue(
                ParamsTest.class.getResourceAsStream("/framework/search_po_test.yaml"),
                POTestCase.class);
        return testCase.testCaseGenerate();
    }

}
