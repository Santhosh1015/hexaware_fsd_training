package com.springboot.helpdesk.repository;

import com.springboot.helpdesk.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer ,Long> {

}
