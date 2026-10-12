package com.springboot.helpdesk.dto.response;

import com.springboot.helpdesk.enums.TicketStatus;

public record TicketStatusCustomerCountDto(
        TicketStatus ticketStatus,
        long numberOfCustomers
) {
}
