package com.helpdesk.mapper;

import com.helpdesk.enums.Priority;
import com.helpdesk.enums.Status;
import com.helpdesk.model.Ticket;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class TicketMapper implements RowMapper<Ticket> {
    @Override
    public Ticket mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Ticket(
                rs.getInt("id"),
                rs.getString("subject"),
                rs.getDate("created_at").toLocalDate(),
                Priority.valueOf(rs.getString("priority")),
                Status.valueOf(rs.getString("status"))
        );
    }
}
