package com.helpdesk.repository;

import com.helpdesk.mapper.UserMapper;
import com.helpdesk.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {
    private final JdbcTemplate jdbcTemplate;
    private final UserMapper userMapper;


    public UserRepository(JdbcTemplate jdbcTemplate, UserMapper userMapper){ // tells spring that i need JDBC Bean here
        this.jdbcTemplate = jdbcTemplate;
        this.userMapper = userMapper;
    }

    public void insertUser(User user) {
        String sql = "insert into users values (?,?,?,?,?)";
        Object[] values = new Object[]{user.getId() , user.getUsername() , user.getPassword() , user.getRole().toString(), user.isActive()};

        jdbcTemplate.update(sql , values);
    }

    public List<User> login(String userName, String password) {

        String sql = """
                select *
                from users
                where username = ? AND password = ? AND is_active=?
                """;
        Object[] values = new Object[]{userName , password , true};
        return jdbcTemplate.query(sql , userMapper, values);
    }
    // for INSERT, UPDATE, DELETE use JDBCTemplate.Update()
    // for fetching the data use JDBCTemplate.query()
}
