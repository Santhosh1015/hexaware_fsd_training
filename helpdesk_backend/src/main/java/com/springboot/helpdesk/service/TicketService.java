package com.springboot.helpdesk.service;

import com.springboot.helpdesk.dto.request.TicketDto;
import com.springboot.helpdesk.enums.TicketStatus;
import com.springboot.helpdesk.exception.ResourceNotFoundException;
import com.springboot.helpdesk.mapper.TicketMapper;
import com.springboot.helpdesk.model.Customer;
import com.springboot.helpdesk.model.Executive;
import com.springboot.helpdesk.model.Ticket;
import com.springboot.helpdesk.repository.CustomerRepository;
import com.springboot.helpdesk.repository.ExecutiveRepository;
import com.springboot.helpdesk.repository.TicketRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TicketService {

    private final TicketRepository ticketRepository;
    private final CustomerRepository customerRepository;
    private final ExecutiveRepository executiveRepository;

    public void add(Long customerId, @Valid TicketDto ticketDto) {
        // step 1. prepare the customer
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(()-> new ResourceNotFoundException("Invalid Customer Id .. Customer Not Found"));

        // step 2. map dto to entity
        Ticket ticket = TicketMapper.convertDtoToEntity(ticketDto);

        // step 3. insert customer with ticket
        ticket.setCustomer(customer);
        ticket.setTicketStatus(TicketStatus.OPEN);

        //step 4. insert ticket into db
        ticketRepository.save(ticket);
    }

    public void assignExecutive(Long ticketId, Long executiveId) {
        // step 1. get the ticket from id
        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(()-> new ResourceNotFoundException("Invalid Ticket ID"));

        // step 2. get the executive from the id
        Executive executive = executiveRepository.findById(executiveId)
                .orElseThrow(()-> new ResourceNotFoundException("Executive Id not found"));

        // step 3. assign the ticket with executive
        ticket.setExecutive(executive);

        // step 4. update the ticket
        ticketRepository.save(ticket);
    }
}
