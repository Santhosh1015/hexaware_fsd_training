package com.springboot.helpdesk.controller;

import com.springboot.helpdesk.dto.request.ExecutiveDto;
import com.springboot.helpdesk.model.Executive;
import com.springboot.helpdesk.service.CustomerService;
import com.springboot.helpdesk.service.ExecutiveService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ExecutiveController {
    private final ExecutiveService executiveService;

    @PostMapping("/api/executive/add/{managerId}")
    //here we are using DTO to hide the direct process with Entity withDB,
    // so using DTO take the required field from the requestBody and validate

    public void insertExecutive(@Valid @RequestBody ExecutiveDto executiveDTO,
                                     @PathVariable Long managerId){
        executiveService.insertExecutive(executiveDTO , managerId);
    }




}
