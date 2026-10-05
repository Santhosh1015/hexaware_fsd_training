package com.library.repository;

import com.library.model.Member;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class MemberRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public Optional<Member> getMemberById(int memberId) {
        return Optional.ofNullable(entityManager.find(Member.class , memberId));
    }
}
