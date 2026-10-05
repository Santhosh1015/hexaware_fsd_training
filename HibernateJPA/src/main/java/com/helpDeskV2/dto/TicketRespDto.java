package com.helpDeskV2.dto;

import com.helpDeskV2.enums.JobTitle;
import com.helpDeskV2.enums.Status;

import java.time.LocalDate;

public record TicketRespDto(
        int ticketId,
        String subject,
        LocalDate createdAr,
        Status status,
        String CustomerName ,
        String CustomerUserName,
        Integer ExecutiveId,
        JobTitle jobTitle
) {
}
