package com.library.mapper;

import com.library.dto.BookDTO;
import com.library.model.Book;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {

    public static BookDTO getBookMapper(Book book){
        return new BookDTO(
            book.getTitle(),
                book.getGenre(),
                book.getPublishedYear(),
                book.getAuthor() == null ?
                        null : book.getAuthor().getName(),
                book.getAuthor() == null ?
                        null : book.getAuthor().getCountry(),
                book.getMember() == null ?
                        null : book.getMember().getEmail()

        );
    }
}
