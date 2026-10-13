package com.springboot.helpdesk.repository;

import com.springboot.helpdesk.dto.request.UserDto;
import com.springboot.helpdesk.enums.Status;
import com.springboot.helpdesk.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Stack;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    @Query("""
            select u
            from User u
            where u.userName = ?1 and u.status = ?2
            
            """)
   User loadUserByUsername(String username , Status status);


}
