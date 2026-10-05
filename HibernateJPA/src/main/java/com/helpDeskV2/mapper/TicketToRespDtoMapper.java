package com.helpDeskV2.mapper;

import com.helpDeskV2.dto.TicketRespDto;
import com.helpDeskV2.model.Ticket;
import org.springframework.stereotype.Component;

import java.time.ZoneId;

@Component
public class TicketToRespDtoMapper {

    public static TicketRespDto getTicketToRespMaper(Ticket ticket){
        return new TicketRespDto(
                ticket.getId(),
                ticket.getSubject(),
                //instance to localDate
                ticket.getCreatedAt().atZone(ZoneId.systemDefault()).toLocalDate(),
                ticket.getStatus(),
                ticket.getCustomer().getName(),
                ticket.getCustomer().getUser() == null ? null : ticket.getCustomer().getUser().getUsername(),
                ticket.getExecutive() ==  null ? null : ticket.getExecutive().getId(),
                ticket.getExecutive() ==  null ? null : ticket.getExecutive().getJobTitle()
        );
    }
}
