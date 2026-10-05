package com.helpDeskV2.main;

import com.helpDeskV2.config.AppConfig;
import com.helpDeskV2.dto.TicketRespDto;
import com.helpDeskV2.enums.Priority;
import com.helpDeskV2.enums.Status;
import com.helpDeskV2.service.TicketService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class TicketController {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        TicketService ticketService = context.getBean(TicketService.class);


        // prepare the object

        int customerId = 1;

        String subject = "Internet cutOff";
        String issue = "Internet cutOff frequently very often";
        Priority priority = Priority.BLUE;
        Status status = Status.OPEN;

        ticketService.raiseTicket(subject , issue , priority , status , customerId);
        System.out.println("Ticket raised successfully..");

        List<TicketRespDto> ticketRespDtoList = ticketService.fetchTicketInfo();
        ticketRespDtoList.forEach(System.out::println);

    }
}
