package com.springboot.helpdesk.service;

import com.springboot.helpdesk.dto.request.ExecutiveDto;
import com.springboot.helpdesk.enums.Role;
import com.springboot.helpdesk.enums.Status;
import com.springboot.helpdesk.exception.ResourceNotFoundException;
import com.springboot.helpdesk.mapper.ExecutiveMapper;
import com.springboot.helpdesk.model.Executive;
import com.springboot.helpdesk.model.Manager;
import com.springboot.helpdesk.model.User;
import com.springboot.helpdesk.repository.ExecutiveRepository;
import com.springboot.helpdesk.repository.ManagerRepository;
import com.springboot.helpdesk.repository.UserRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
@RequiredArgsConstructor
public class ExecutiveService {

    private final ExecutiveRepository executiveRepository;
    private final UserRepository userRepository;
    private final ManagerRepository managerRepository;
    private final PasswordEncoder passwordEncoder;

    public void insertExecutive(@Valid ExecutiveDto executiveDTO, String managerUserName) {


        //step 0. check Manager is in DB to create executive
        Manager manager  = managerRepository.getByUserName(managerUserName);
        if (manager == null) {
            throw new RuntimeException(
                    "Manager not found for username: " + managerUserName
            );
        }
        //filed for user is coming from DTO
        //step1. let the user go in DB first
        User user = new User();
        user.setUserName(executiveDTO.username());
        user.setPassword(passwordEncoder.encode(executiveDTO.password()));
        user.setRole(Role.EXECUTIVE);
        user.setStatus(Status.ACTIVE);
        user = userRepository.save(user);

        // step 2. map the executiveDto into executive using mapper
        Executive executive = ExecutiveMapper.mapDtoToEntity(executiveDTO);

        //step 3. set user into Executive Entity as FK
        executive.setUser(user);
        executive.setManager(manager);

        //step 4. insert executive  into DB
        executiveRepository.save(executive);
    }
}
