package com.helpdesk.repository;

import com.helpdesk.mapper.TicketMapper;
import com.helpdesk.model.Customer;
import com.helpdesk.model.Ticket;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public class CustomerRepository {
    private final JdbcTemplate jdbcTemplate;
    private final TicketMapper ticketMapper;

    public CustomerRepository(JdbcTemplate jdbcTemplate, TicketMapper ticketMapper){ // tells spring that i need JDBC Bean here
        this.jdbcTemplate = jdbcTemplate;
        this.ticketMapper = ticketMapper;
    }


    public void insertCustomer(Customer customer) {
        String sql = "insert into customer values (?,?,?,?,?)";
        Object[] values = new Object[]{customer.getId() , customer.getName() , customer.getAge(), customer.getPlan().toString(), customer.getUser().getId()};

        jdbcTemplate.update(sql , values);
    }

    public List<Ticket> getAllTickets(String userName) throws SQLException {
        String sql = """
                select t.id , t.subject , t.created_at , t.priority , t.status
                from users u
                join customer c on u.id = c.user_id
                join ticket t on t.customer_id = c.id
                where u.username = ?
                """;
        return jdbcTemplate.query(sql , ticketMapper , userName);
    }
}
