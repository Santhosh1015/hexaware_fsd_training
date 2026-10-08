package com.springboot.helpdesk.controller;

import com.springboot.helpdesk.dto.request.TicketDto;
import com.springboot.helpdesk.dto.response.ExecutiveTicketInfoDto;
import com.springboot.helpdesk.dto.response.TicketRespDto;
import com.springboot.helpdesk.model.Ticket;
import com.springboot.helpdesk.service.TicketService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class TicketController {

    private final TicketService ticketService;

    @PostMapping("/api/ticket/add/{customerId}")
    public void insertTicket(@Valid  @RequestBody TicketDto ticketDto,
                                       @PathVariable Long customerId){
        ticketService.add(customerId , ticketDto);
    }

    @PutMapping("/api/ticket/assign/{ticketId}/{executiveId}")
    public void assignExecutive(@PathVariable Long ticketId ,
                                @PathVariable Long executiveId){
        ticketService.assignExecutive(ticketId , executiveId);

    }

    @GetMapping("/api/ticket/v1/{customerId}")
    // this pai says it is mandatory to have the pagination here
    public List<TicketRespDto> getTicketByCustomerId(@PathVariable Long customerId,
                                                     @RequestParam("page") int page,
                                                     @RequestParam("size") int size)
    {
        return ticketService.getTicketByCustomerId(customerId,page , size);
    }

    @GetMapping("/api/ticket/v2")
    // but here we can make pagination optional by giving default value
    public List<TicketRespDto> getTicketByCustomerUsername(@RequestParam("username") String customerUsername,
                                                     @RequestParam(name = "page",required = false, defaultValue = "0") Integer page,
                                                     @RequestParam(name = "size" , required = false , defaultValue = "10") Integer size)
    {
        return ticketService.getTicketByCustomerUsername(customerUsername,page , size);
    }

    @GetMapping("/api/v1/executive/ticket")
    public List<ExecutiveTicketInfoDto> getTicketsByExecutiveUsername(@RequestParam("username") String username,
                                                                      @RequestParam(name = "page",required = false, defaultValue = "0")Integer page,
                                                                      @RequestParam(name = "size" , required = false , defaultValue = "10")Integer size){
        return ticketService.getTicketsByExecutiveUsername(username , page, size);
    }

}
