package com.springboot.helpdesk.controller;

import com.springboot.helpdesk.dto.request.UserDto;
import com.springboot.helpdesk.repository.UserRepository;
import com.springboot.helpdesk.service.AdminService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;

    @PostMapping("/api/admin/add")
    public void addAdmin(@Valid @RequestBody UserDto userDto){
       adminService.addAdmin(userDto);
    }
}
