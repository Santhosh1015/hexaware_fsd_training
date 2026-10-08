package com.springboot.helpdesk.mapper;

import com.springboot.helpdesk.dto.request.TicketDto;
import com.springboot.helpdesk.model.Ticket;
import jakarta.validation.Valid;

public class TicketMapper {

    public static Ticket convertDtoToEntity(@Valid TicketDto ticketDto) {
        Ticket ticket = new Ticket();
        ticket.setPriority(ticketDto.priority());
        ticket.setIssue(ticketDto.issue());
        ticket.setSubject(ticketDto.subject());

        return ticket;
    }
}
