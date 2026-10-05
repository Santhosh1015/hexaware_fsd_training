package com.helpDeskV2.repository;

import com.helpDeskV2.model.Ticket;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@Repository
public class TicketRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void insert(Ticket ticket) {
        entityManager.persist(ticket);
    }

    public List<Ticket> fetchTicketInfoV1() {
        String jpql = "select t from Ticket t";
        return entityManager.createQuery(jpql , Ticket.class).getResultList();
    }
//    public List<Ticket> fetchTicketInfoV2() {
//        String jpql = """
//                select t from Ticket t
//                join t.customer c
//                join t.executive e
//                """;
//        return entityManager.createQuery(jpql , Ticket.class).getResultList();
//    }

}
