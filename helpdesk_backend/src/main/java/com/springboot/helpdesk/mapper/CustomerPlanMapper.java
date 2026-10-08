package com.springboot.helpdesk.mapper;

import com.springboot.helpdesk.dto.request.CustomerPlanDto;
import com.springboot.helpdesk.model.CustomerPlan;

public class CustomerPlanMapper {



    public static CustomerPlan convertDtoIntoEntity(CustomerPlanDto customerPlanDto) {
        CustomerPlan customerPlan = new CustomerPlan();
        customerPlan.setActivationDate(customerPlanDto.activationDate());
        customerPlan.setAmountPaid(customerPlanDto.amountPaid());
        customerPlan.setEndDate(customerPlanDto.endDate());
        customerPlan.setCoupon(customerPlanDto.coupon());
        return customerPlan;
    }


}
