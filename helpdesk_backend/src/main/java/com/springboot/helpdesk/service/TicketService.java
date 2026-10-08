package com.springboot.helpdesk.service;

import com.springboot.helpdesk.dto.request.TicketDto;
import com.springboot.helpdesk.dto.response.ExecutiveTicketInfoDto;
import com.springboot.helpdesk.dto.response.TicketRespDto;
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
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<TicketRespDto> getTicketByCustomerUsername(String customerUsername,int page, int size) {

        Pageable pageable = PageRequest.of(page , size);
        return ticketRepository.getTicketByCustomerUsername(customerUsername, pageable);
    }

    public List<TicketRespDto> getTicketByCustomerId(Long customerId,int page, int size) {

        Pageable pageable = PageRequest.of(page , size);
        return ticketRepository.getTicketByCustomerId(customerId, pageable);
    }

    public List<ExecutiveTicketInfoDto> getTicketsByExecutiveUsername(String username, Integer page, Integer size) {

        Pageable pageable =PageRequest.of(page , size);
        return ticketRepository.getTicketsByExecutiveUsername(username , pageable);
    }
}
