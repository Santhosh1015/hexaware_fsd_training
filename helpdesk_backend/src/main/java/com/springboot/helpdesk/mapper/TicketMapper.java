package com.springboot.helpdesk.mapper;

import com.springboot.helpdesk.dto.request.TicketDto;
import com.springboot.helpdesk.dto.response.TicketResDto;
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
    public static TicketResDto convertEntityToDto(Ticket ticket){
        return
                new TicketResDto (
                        ticket.getId(),
                        ticket.getSubject(),
                        ticket.getCreatedAt(),
                        ticket.getPriority(),
                        ticket.getTicketStatus()
                );
    }
}
