package com.library.repository;

import com.library.model.Author;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class AuthorRepository {
    @PersistenceContext
    private EntityManager entityManager;

    // but this find return author, but we can't guarantee that id is exists
    public Optional<Author> getAuthorById(int authorId) {
        return Optional.ofNullable(entityManager.find(Author.class, authorId));
    }
}
