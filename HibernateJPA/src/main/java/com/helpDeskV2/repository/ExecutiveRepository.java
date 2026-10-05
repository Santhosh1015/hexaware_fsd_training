package com.helpDeskV2.repository;

import com.helpDeskV2.model.Executive;
import com.helpDeskV2.model.Manager;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public class ExecutiveRepository {

    @PersistenceContext
    private EntityManager entityManager;



    @Transactional
    public Optional<Manager> fetchMangerById(int managerId) {
        // if the manager is null it returns Optional<null>
        // not create a NUllPOINTER EXCEPTION
        return Optional.ofNullable(entityManager.find(Manager.class , managerId));

    }

    @Transactional
    public void insert(Executive executive) {
        entityManager.persist(executive);
    }
}
