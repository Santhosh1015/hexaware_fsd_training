package com.springboot.helpdesk.repository;

import com.springboot.helpdesk.dto.response.ExecutiveTicketInfoDto;
import com.springboot.helpdesk.dto.response.TicketRespDto;
import com.springboot.helpdesk.model.Ticket;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    @Query("""
            select new com.springboot.helpdesk.dto.response.TicketRespDto(t.id,t.subject,t.createdAt,t.priority,t.ticketStatus,c.name,e.name,e.email)
            from Ticket t
            left join t.customer c
            left join t.executive e
            where c.id = ?1
            """)
    List<TicketRespDto> getTicketByCustomerId(Long customerId, Pageable pageable);

    @Query("""
            select new com.springboot.helpdesk.dto.response.TicketRespDto(t.id,t.subject,t.createdAt,t.priority,t.ticketStatus,c.name,e.name,e.email)
            from Ticket t
            left join t.customer c
            left join t.executive e
            left join c.user u
            where u.userName = ?1
            """)
    List<TicketRespDto> getTicketByCustomerUsername(String customerUsername, Pageable pageable);

    @Query("""
            select new com.springboot.helpdesk.dto.response.ExecutiveTicketInfoDto(t.id,e.id,e.name,t.subject,t.priority,t.ticketStatus,t.createdAt,c.id,c.name)
            from Ticket t
            join t.executive e
            join t.customer c
            join e.user u
            where u.userName = ?1
            """)
    List<ExecutiveTicketInfoDto> getTicketsByExecutiveUsername(String username, Pageable pageable);
}
