package com.springboot.helpdesk.controller;

import com.springboot.helpdesk.dto.request.CustomerPlanDto;
import com.springboot.helpdesk.dto.response.CustomerPlanRespDto;
import com.springboot.helpdesk.service.CustomerPlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CustomerPlanController {

    private final CustomerPlanService customerPlanService;

    @PostMapping("/api/v1/customer/plan/add/{customerId}/{planId}")
    public void addCustomerPlan(@RequestBody CustomerPlanDto customerPlanDto,
                                @PathVariable Long customerId,
                                @PathVariable Long planId){
        customerPlanService.addCustomerPlan(customerPlanDto , customerId , planId);
    }
    @GetMapping("/api/v1/customer/plan")
    public List<CustomerPlanRespDto> fetchPlansByCustomerUsername(@RequestParam("username") String username,
                                                                  @RequestParam(name = "page" , required = false , defaultValue = "0") Integer page,
                                                                  @RequestParam(name = "size" , required = false , defaultValue = "10") Integer size){
        return customerPlanService.fetchPlansByCustomerUsername(username , page , size);

    }

}
