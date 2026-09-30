package com.helpdesk.service;

import com.helpdesk.exceptions.InvalidCredentialsException;
import com.helpdesk.model.User;
import com.helpdesk.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public void createUser(User user) {
        int userId = (int)(Math.random()*100000);
        user.setId(userId);
        userRepository.insertUser(user);

    }

    public User login(String userName, String password) throws InvalidCredentialsException {

       List<User> list = userRepository.login(userName , password);
       if(list == null || list.isEmpty())
           throw new InvalidCredentialsException("Invalid Credentials...");
       return list.getFirst();
    }
}
