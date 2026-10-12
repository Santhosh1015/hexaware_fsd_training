package com.springboot.helpdesk.repository;

import com.springboot.helpdesk.dto.response.JobTitleExecutiveCountDto;
import com.springboot.helpdesk.model.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Long> {

    @Query("""
            select e.jobTitle as jobTitle, count(e.id) as numberOfExecutives
            from Executive  e
            where e.jobTitle is not null
            group by e.jobTitle
            """)
    List<JobTitleExecutiveCountDto> getExecutiveCountByJobTitleStat();
}
