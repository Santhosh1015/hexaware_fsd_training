package com.springboot.helpdesk.dto.response;

import com.springboot.helpdesk.enums.Priority;
import com.springboot.helpdesk.enums.TicketStatus;

import java.time.Instant;

public record ExecutiveTicketInfoDto(

        long ticketId,
        long executiveId,
        String executiveName,
        String ticketSubject,
        Priority tickerPriority,
        TicketStatus ticketStatus,
        Instant ticketCreatedAt,
        long customerId,
        String customerName
) {
}
