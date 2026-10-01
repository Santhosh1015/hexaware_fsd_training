package com.helpDeskV2.repository;

import com.helpDeskV2.model.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional // if there are two more ops, it will ensure complete tran or roll back
    public void insert(Customer customer) {
        entityManager.persist(customer);
    }

    public List<Customer> getAllCustomers() {
        String jpql = "select c from Customer c";// JPQL which use class as entity like customer - Customer
        String hql = "from Customer c"; // HQL for hibernate
        String sql = "select * from customer"; // this won't work cause it work with Entity Classes not with DB tables

        return entityManager.createQuery(jpql ,Customer.class).getResultList(); // it will going to return he

//        return entityManager.createQuery(hql , Customer.class).getResultList(); // hql using createQuery

//        return entityManager.createNativeQuery(sql, Customer.class).getResultList(); // it introduce classCast problme
        // to use List<?>


    }
}
