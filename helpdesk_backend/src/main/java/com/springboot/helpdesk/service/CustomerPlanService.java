package com.springboot.helpdesk.service;

import com.springboot.helpdesk.dto.request.CustomerPlanDto;
import com.springboot.helpdesk.dto.response.CustomerPlanRespDto;
import com.springboot.helpdesk.exception.ResourceNotFoundException;
import com.springboot.helpdesk.mapper.CustomerPlanMapper;
import com.springboot.helpdesk.model.Customer;
import com.springboot.helpdesk.model.CustomerPlan;
import com.springboot.helpdesk.model.Plan;
import com.springboot.helpdesk.repository.CustomerPlanRepository;
import com.springboot.helpdesk.repository.CustomerRepository;
import com.springboot.helpdesk.repository.PlanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerPlanService {

    private final CustomerPlanRepository customerPlanRepository;
    private final PlanRepository planRepository;
    private final CustomerRepository customerRepository;

    public void addCustomerPlan(CustomerPlanDto customerPlanDto , Long customerId,Long plan_id ) {
        // step 1. prepare the plan object
        Plan plan = planRepository.findById(plan_id)
                        .orElseThrow(()-> new ResourceNotFoundException("Plan Id is invalid"));

        // step 2. prepare the customer Object
        Customer customer = customerRepository.findById(customerId)
                        .orElseThrow(()-> new ResourceNotFoundException("Customer Id is invalid"));

        // step 3. set the fields by mapping
        CustomerPlan customerPlan = CustomerPlanMapper.convertDtoIntoEntity(customerPlanDto);
        customerPlan.setPlan(plan);
        customerPlan.setCustomer(customer);

        customerPlanRepository.save(customerPlan);
    }


    public List<CustomerPlanRespDto> fetchPlansByCustomerUsername(String username, Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page , size);
        return customerPlanRepository.fetchPlansByCustomerUsername(username , pageable);
    }
}
