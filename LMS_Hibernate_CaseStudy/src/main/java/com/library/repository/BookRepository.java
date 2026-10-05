package com.library.repository;

import com.library.dto.BookDTO;
import com.library.mapper.BookMapper;
import com.library.model.Book;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BookRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public void insert(Book book) {
        entityManager.persist(book);
    }

    public Optional<Book> findBookById(int bookId) {
        return Optional.ofNullable(entityManager.find(Book.class , bookId));
    }

    public List<BookDTO> fetchAllBooks() {
        String jpql = """
                select b
                from Book b
                left join b.author a
                left join b.member m
                """;

        return entityManager
                .createQuery(jpql , Book.class)
                .getResultList()
                .stream()
                .map(BookMapper::getBookMapper)
                .toList();
    }
}
