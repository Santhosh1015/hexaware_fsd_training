package com.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DemoServiceTest {
    DemoService demoService;

    // calls before each test case starts
    @BeforeEach
    public void init(){
        demoService = new DemoService();
        System.out.println("initiated...");
    }
    @Test
    public void sumTest(){
        System.out.println("Inside Test Method..");

        // useCase : both +ve nums
        int actualOutput = demoService.sum(5 , 6);
        int expectedOutput = 11;
        Assertions.assertEquals(expectedOutput , actualOutput);

        // useCase : one +ve  and _ve nums
        actualOutput = demoService.sum(-5 , 3);
        expectedOutput = -2;
        Assertions.assertEquals(expectedOutput , actualOutput);

        // useCase : both _ve nums
        actualOutput = demoService.sum(-5 , -3);
        expectedOutput = -8;
        Assertions.assertEquals(expectedOutput , actualOutput);

        // useCase : going wrong and fixing..
        actualOutput = demoService.sum(-5 , -3);
        expectedOutput = -10;
        Assertions.assertNotEquals(expectedOutput , actualOutput);

    }

    // it calls after each test case executed..
    @AfterEach
    public void destroy(){
        demoService = null;
        System.out.println("destroyed...");
    }


}
