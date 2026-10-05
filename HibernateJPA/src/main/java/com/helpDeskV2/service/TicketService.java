package com.helpDeskV2.service;

import com.helpDeskV2.dto.TicketRespDto;
import com.helpDeskV2.enums.Priority;
import com.helpDeskV2.enums.Status;
import com.helpDeskV2.exception.ResourceNotFoundException;
import com.helpDeskV2.mapper.TicketToRespDtoMapper;
import com.helpDeskV2.model.Customer;
import com.helpDeskV2.model.Ticket;
import com.helpDeskV2.repository.CustomerRepository;
import com.helpDeskV2.repository.TicketRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService {
    private final TicketRepository ticketRepository;
    private final CustomerRepository customerRepository;

    public TicketService(TicketRepository ticketRepository, CustomerRepository customerRepository) {
        this.ticketRepository = ticketRepository;
        this.customerRepository = customerRepository;
    }

    @Transactional
    public void raiseTicket(String subject, String issue, Priority priority, Status status, int customerId) {

        //step 1. fetch customer Object by id
        Optional<Customer> customerOptional = customerRepository.getCustomerById(customerId);
        if(customerOptional.isEmpty())
            throw new ResourceNotFoundException("CustomerID is invalid");
        Customer customer = customerOptional.get();

        //step 2. prepare a ticket object

        Ticket ticket = new Ticket(subject, issue , priority , status);

        //step 3. set a customer object
        ticket.setCustomer(customer);

        //step 4. insert ticket

        ticketRepository.insert(ticket);


    }

    public List<TicketRespDto> fetchTicketInfo() {
        List<Ticket> ticketList = ticketRepository.fetchTicketInfoV1();

        return
                ticketList
                        .stream()
                        .map(TicketToRespDtoMapper::getTicketToRespMaper)
                        .toList();


    }
}
