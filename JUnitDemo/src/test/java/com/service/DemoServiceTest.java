package com.service;

import com.exception.EmptyListException;
import com.exception.InvalidInputException;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;


public class DemoServiceTest {
    DemoService demoService;
    List<Double> listMarks1;
    List<Double> listMarks2;
    List<Double> listMarks3;
    List<Double> listMarks4;
    List<Double> listMarks5;
    List<Double> listMarks6;
    List<Double> listMarks7;

    // calls before each test case starts
    @BeforeEach
    public void init(){
        demoService = new DemoService();
        listMarks1 = List.of(78d,58d,86d,75d); // valid
        listMarks2 = List.of(78d,105d,86d,75d);// invalid - >100
        listMarks3 = List.of(78d,58d,86d,-3d);// invalid - <0
        listMarks4 = null; // invalid - empty
        listMarks5 = List.of(78d,78d,86d,75d); // valid
        listMarks6 = List.of(68d,58d,56d,45d); // valid
        listMarks7 = List.of();
    }
    @Test
    public void sumTest(){

        // useCase : both +ve nums
        int actualOutput = demoService.sum(5 , 6);
        int expectedOutput = 11;
        assertEquals(expectedOutput , actualOutput);

        // useCase : one +ve  and _ve nums
        actualOutput = demoService.sum(-5 , 3);
        expectedOutput = -2;
        assertEquals(expectedOutput , actualOutput);

        // useCase : both _ve nums
        actualOutput = demoService.sum(-5 , -3);
        expectedOutput = -8;
        assertEquals(expectedOutput , actualOutput);

        // useCase : going wrong and fixing..
        actualOutput = demoService.sum(-5 , -3);
        expectedOutput = -10;
        assertNotEquals(expectedOutput , actualOutput);

    }

    @Test
    public void computeGradeTestFunctional(){
        assertNotNull(listMarks1);
        assertEquals("B" , demoService.computeGrade(listMarks1));
        assertNotNull(listMarks5);
        assertEquals("A" , demoService.computeGrade(listMarks5));
        assertNotNull(listMarks6);
        assertEquals("C", demoService.computeGrade(listMarks6));


    }
    @Test
    public void computeGradeTestValidations(){
        assertEquals("List Can't be NULL" ,
                        assertThrows(NullPointerException.class ,
                                        ()->demoService.computeGrade(listMarks4)).getMessage());
        assertEquals("List can't be Empty" ,
                assertThrows(EmptyListException.class ,
                        ()->demoService.computeGrade(listMarks7)).getMessage());

        assertEquals("The Marks should be btw 0 - 100" ,
                assertThrows(InvalidInputException.class ,
                        ()->demoService.computeGrade(listMarks2)).getMessage());
        assertEquals("The Marks should be btw 0 - 100" ,
                assertThrows(InvalidInputException.class ,
                        ()->demoService.computeGrade(listMarks3)).getMessage());
    }

    // it calls after each test case executed..
    @AfterEach
    public void destroy(){
        demoService = null;
    }


}
