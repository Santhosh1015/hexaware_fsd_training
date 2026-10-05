package com.library.dto;

import com.library.enums.Genre;

import java.util.List;

public record BookDTO(
        String bookName,
        Genre genre,
        int publishedYear,
        String authorName,
        String authorCountry,
        String borrowerEmail
) {
}
