package com.springboot.helpdesk.repository;

import com.springboot.helpdesk.dto.response.ExecutiveTicketInfoDto;
import com.springboot.helpdesk.dto.response.TicketResDto;
import com.springboot.helpdesk.dto.response.TicketRespDto;
import com.springboot.helpdesk.dto.response.TicketStatusCustomerCountDto;
import com.springboot.helpdesk.enums.Priority;
import com.springboot.helpdesk.enums.TicketStatus;
import com.springboot.helpdesk.model.Ticket;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.Instant;
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


    @Query("""
            select t.ticketStatus as ticketStatus , COALESCE(count(c.id),0) as numberOfCustomers
            from Ticket t
            join t.customer c
            where t.ticketStatus is not null
            group by t.ticketStatus
            """)
    List<TicketStatusCustomerCountDto> getCustomerCountByTicketStat();

    List<Ticket> findByPriority(Priority priority);

    List<Ticket> findBySubject(String subject);

    List<Ticket> findByTicketStatus(TicketStatus ticketStatus);

    @Query("""
            select t.id as ticketId, t.subject as subject, t.createdAt as createdAt, t.priority as priority, t.ticketStatus as ticketStatus
            from Ticket t
            where (?1 is null or t.priority = ?1)
            and (?2 is null or t.ticketStatus = ?2)
            and (?3 is null or t.createdAt >= ?3)
            and (?4 is null or t.createdAt <= ?4)
            """)
    List<TicketResDto> dynamicFilterTicket(Priority priority, TicketStatus ticketStatus, Instant instant, Instant instant1);
}
