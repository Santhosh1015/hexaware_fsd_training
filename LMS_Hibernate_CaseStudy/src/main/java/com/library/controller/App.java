package com.library.controller;

import com.library.config.AppConfig;
import com.library.dto.BookDTO;
import com.library.enums.Genre;
import com.library.enums.Status;
import com.library.model.Book;
import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        BookService bookService = context.getBean(BookService.class);

        // Task 1. Save Book into DB using hibernateJPA

        // prepare input
//        int authorId = 1;
//        int memberId = 1;
//
//        String title = "Rich Dad Poor Dad";
//        int publishedYear = 1997;
//        Status status = Status.AVAILABLE;
//        Genre genre = Genre.NON_FICTION;
//        Book book = new Book();
//        book.setTitle(title);
//        book.setGenre(genre);
//        book.setPublishedYear(publishedYear);
//        book.setStatus(status);
//
//        bookService.save(book , authorId , memberId);
//        System.out.println("Book Saved successfully...");

        //Task 2. Find the Book using its Id

//        int bookId = 1;
//        Book book = bookService.findBookById(bookId);
//        System.out.println("Fetched Book : "+book);

        //Task 3. fetch all books from DB

        System.out.println("Get all Books Details");
        List<BookDTO> bookDTOList = bookService.fetchAllBooks();
        bookDTOList.forEach(System.out::println);
    }
}
