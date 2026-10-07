package com.springboot.helpdesk.controller;

import com.springboot.helpdesk.dto.request.ExecutiveDto;
import com.springboot.helpdesk.model.Executive;
import com.springboot.helpdesk.service.CustomerService;
import com.springboot.helpdesk.service.ExecutiveService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ExecutiveController {
    private final ExecutiveService executiveService;

    @PostMapping("/api/executive/add")
    //here we are using DTO to hide the direct process with Entity withDB,
    // so using DTO take the required field from the requestBody and validate

    public Executive insertExecutive(@Valid @RequestBody ExecutiveDto executiveDTO){
        return executiveService.insertExecutive(executiveDTO);
    }

}
