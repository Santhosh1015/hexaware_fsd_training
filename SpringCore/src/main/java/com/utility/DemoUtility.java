package com.utility;

import org.springframework.stereotype.Component;

@Component // general annotation instead of @service @Repository where you may not know about the class's job
public class DemoUtility {
    public void test(){
        System.out.println("In Utility...");
    }
}
