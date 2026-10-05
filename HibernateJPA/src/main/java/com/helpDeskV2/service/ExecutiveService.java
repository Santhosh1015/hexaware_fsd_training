package com.helpDeskV2.service;

import com.helpDeskV2.enums.Role;
import com.helpDeskV2.exception.ResourceNotFoundException;
import com.helpDeskV2.model.Executive;
import com.helpDeskV2.model.Manager;
import com.helpDeskV2.model.User;
import com.helpDeskV2.repository.ExecutiveRepository;
import com.helpDeskV2.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.hibernate.engine.spi.Managed;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class ExecutiveService {

    private final ExecutiveRepository executiveRepository;
    private final UserRepository userRepository;

    public ExecutiveService(ExecutiveRepository executiveRepository, UserRepository userRepository) {
        this.executiveRepository = executiveRepository;
        this.userRepository = userRepository;
    }


    public void insertExecutive(int managerId, Executive executive, String userName, String password) {

        //step 1. validate and get the manager object using ManagerID
        // to validate we not guarantee on getting Manager
        Optional<Manager> optionalManager = executiveRepository.fetchMangerById(managerId);
        if(optionalManager.isEmpty())
            throw new ResourceNotFoundException("Manager Id does not exists");
        Manager manager = optionalManager.get();

        //step 2. prepare a user object using username and Pass
        User user = new User(userName , password , Role.EXECUTIVE);

        // you have to insert this first and get the object from hibernating
        userRepository.insert(user);
//        List<User> userList = userRepository.getUserByUsername(userName);
//        user = userList.getFirst();

        executive.setUser(user);
        executive.setManager(manager);

        //step 3. create an executive object and pass to repo
        executiveRepository.insert(executive);

    }
}
