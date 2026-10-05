package com.helpDeskV2.main;

import com.helpDeskV2.config.AppConfig;
import com.helpDeskV2.enums.JobTitle;
import com.helpDeskV2.model.Executive;
import com.helpDeskV2.service.ExecutiveService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ExecutiveController {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        ExecutiveService executiveService = context.getBean(ExecutiveService.class);

        // insert the executive int DB
        int manager_id = 1;

        Executive executive = new Executive();
        executive.setName("Tom Charles");
        executive.setJobTitle(JobTitle.TECH_SUPPORT);

        String userName = "charles@yahoo.com";
        String password ="charles@321";

        System.out.println("Executive Insertion");
        try {
            executiveService.insertExecutive(manager_id , executive , userName , password);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        System.out.println("Executive Inserted successfully...");
    }
}
/*
Spring Context
----------------
ExecutiveService
ExecutiveRepository
EntityManager (persistence)

 */
