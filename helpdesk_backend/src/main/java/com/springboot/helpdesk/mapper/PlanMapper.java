package com.springboot.helpdesk.mapper;

import com.springboot.helpdesk.dto.request.PlanDto;
import com.springboot.helpdesk.model.Plan;

public class PlanMapper {


    public static Plan convertDtoToEntity(PlanDto planDto) {
        Plan plan = new Plan();
        plan.setPlanType(planDto.planType());
        plan.setPrice(planDto.price());
        return plan;
    }


}
