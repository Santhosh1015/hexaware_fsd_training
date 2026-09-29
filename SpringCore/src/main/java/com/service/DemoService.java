package com.service;

import com.dao.DemoDAO;
import org.springframework.stereotype.Service;

@Service
public class DemoService {

//    DemoDAO dao = new DemoDAO(); // POJO - managing bean manually

    private final DemoDAO dao;

    public DemoService(DemoDAO dao) {
        this.dao =dao;
    }



    public void test(){
        System.out.println("In service...");
        dao.test();

    }
}
