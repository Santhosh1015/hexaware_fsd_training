package com.springboot.helpdesk.service;

import com.springboot.helpdesk.dto.request.UserDto;
import com.springboot.helpdesk.enums.Role;
import com.springboot.helpdesk.enums.Status;
import com.springboot.helpdesk.model.User;
import com.springboot.helpdesk.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void addAdmin(UserDto userDto) {
        User user = new User();
        user.setUserName(userDto.username());
        user.setPassword(passwordEncoder.encode(userDto.password()));
        user.setRole(Role.ADMIN);
        user.setStatus(Status.ACTIVE);
        userRepository.save(user);
    }
}
