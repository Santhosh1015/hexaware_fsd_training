package com.helpDeskV2.repository;

import com.helpDeskV2.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {

    @PersistenceContext
    private EntityManager entityManager;


    @Transactional
    public void insert(User user) {
        entityManager.persist(user);
    }

    @Transactional
    public List<User> getUserByUsername(String userName) {
        String jpql = "select u from User u where userName = ?1";
        return entityManager.createQuery(jpql , User.class)
                .setParameter(1 , userName)
                .getResultList();
    }
}
