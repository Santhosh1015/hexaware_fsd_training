package com.springboot.helpdesk.dto.response;

import com.springboot.helpdesk.enums.Priority;
import com.springboot.helpdesk.enums.TicketStatus;

import java.time.Instant;

public record TicketRespDto(
        Long ticketId,
        String subject,
        Instant createdAt,
        Priority priority,
        TicketStatus ticketStatus,
        String customerName,
        String executiveName,
        String executiveEmail
) {
}
