package com.springboot.helpdesk.service;

import com.springboot.helpdesk.dto.request.ManagerDto;
import com.springboot.helpdesk.dto.response.JobTitleExecutiveCountDto;
import com.springboot.helpdesk.enums.JobTitle;
import com.springboot.helpdesk.enums.Role;
import com.springboot.helpdesk.enums.Status;
import com.springboot.helpdesk.exception.ResourceNotFoundException;
import com.springboot.helpdesk.mapper.ManagerMapper;
import com.springboot.helpdesk.model.Executive;
import com.springboot.helpdesk.model.Manager;
import com.springboot.helpdesk.model.User;
import com.springboot.helpdesk.repository.ExecutiveRepository;
import com.springboot.helpdesk.repository.ManagerRepository;
import com.springboot.helpdesk.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ManagerService {

    private final ManagerRepository managerRepository;
    private final ExecutiveRepository executiveRepository;
    private final UserRepository userRepository;

    public void insert(ManagerDto managerDto) {
        //step 1. prepare a user object
        User user = new User();
        user.setUserName(managerDto.userName());
        user.setPassword(managerDto.password());
        user.setRole(Role.MANAGER);
        user.setStatus(Status.ACTIVE);

        user = userRepository.save(user);

        //step 2.map the manager DTO to manager entity
        Manager manager = ManagerMapper.mapDtoToManager(managerDto);

        //step 3. make the user set to the manager
        manager.setUser(user);

        managerRepository.save(manager);

    }

    public void updateJobTitle(long executiveId, JobTitle jobTitle) {
        Executive executive = executiveRepository.findById(executiveId)
                        .orElseThrow(()-> new ResourceNotFoundException("Executive Id is invalid"));

        executive.setJobTitle(jobTitle);

        executiveRepository.save(executive);
    }

    public List<JobTitleExecutiveCountDto> getExecutiveCountByJobTitleStat() {
        return managerRepository.getExecutiveCountByJobTitleStat();
    }
}
