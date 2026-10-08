package com.springboot.helpdesk.controller;

import com.springboot.helpdesk.dto.request.TicketDto;
import com.springboot.helpdesk.model.Ticket;
import com.springboot.helpdesk.service.TicketService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;

@RestController
@RequiredArgsConstructor
public class TicketController {

    private final TicketService ticketService;

    @PostMapping("/api/ticket/add/{customerId}")
    public void insertTicket(@Valid  @RequestBody TicketDto ticketDto,
                                       @PathVariable Long customerId
    ){
        ticketService.add(customerId , ticketDto);
    }

    @PutMapping("/api/ticket/assign/{ticketId}/{executiveId}")
    public void assignExecutive(@PathVariable Long ticketId ,
                                @PathVariable Long executiveId){
        ticketService.assignExecutive(ticketId , executiveId);

    }
}
