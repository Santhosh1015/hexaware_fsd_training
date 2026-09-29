package com.service;

import com.dao.DemoDAO;
import com.mapper.DemoMapper;
import com.utility.DemoUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemoService {

//    DemoDAO dao = new DemoDAO(); // POJO - managing bean manually


//    private final DemoDAO dao;
//
//    private final DemoMapper mapper;
//
//    private final DemoUtility utility;

    // 1- Using Constructor -> better way to use because it is easy to test and guaranteed to use the class in constructor

//    public DemoService(DemoDAO dao, DemoMapper mapper, DemoUtility utility) {
//        this.dao =dao;
//        this.mapper = mapper;
//        this.utility = utility;
//    }
    // 2 - autowired -> it is hard if you test that from JUnit and risky if you forgot to autowire
//    @Autowired
//    private DemoDAO dao;
//        @Autowired
//        private DemoMapper mapper;
//        @Autowired
//        private DemoUtility utility;

    // 3- autowired using setter

    private DemoDAO dao;

    private DemoMapper mapper;

    private DemoUtility utility;

    @Autowired
    public void setDao(DemoDAO dao) {
        this.dao = dao;
    }

    @Autowired
    public void setMapper(DemoMapper mapper) {
        this.mapper = mapper;
    }

    @Autowired
    public void setUtility(DemoUtility utility) {
        this.utility = utility;
    }

    public void test(){
        System.out.println("In service...");
        dao.test();
        mapper.test();
        utility.test();

    }
}
