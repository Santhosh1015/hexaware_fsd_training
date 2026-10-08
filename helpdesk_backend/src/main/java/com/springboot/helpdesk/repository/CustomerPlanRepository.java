package com.springboot.helpdesk.repository;

import com.springboot.helpdesk.dto.response.CustomerPlanRespDto;
import com.springboot.helpdesk.model.CustomerPlan;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerPlanRepository extends JpaRepository<CustomerPlan , Long> {
    @Query("""
            select new com.springboot.helpdesk.dto.response.CustomerPlanRespDto(c.name,p.planType,cp.amountPaid,cp.activationDate,cp.endDate,cp.coupon)
            from CustomerPlan cp
            join cp.customer c
            join cp.plan p
            join c.user u
            where u.userName = ?1
            """)
    List<CustomerPlanRespDto> fetchPlansByCustomerUsername(String username, Pageable pageable);
}
