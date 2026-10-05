package com.library.service;

import com.library.dto.BookDTO;
import com.library.exception.ResourceNotFoundException;
import com.library.model.Author;
import com.library.model.Book;
import com.library.model.Member;
import com.library.repository.AuthorRepository;
import com.library.repository.BookRepository;
import com.library.repository.MemberRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final MemberRepository memberRepository;

    public BookService(BookRepository bookRepository, AuthorRepository authorRepository, MemberRepository memberRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.memberRepository = memberRepository;
    }

    @Transactional
    public void save(Book book , int author_id , int member_id) {

        // step 1. get the object of the author
        Optional<Author> authorOptional = authorRepository.getAuthorById(author_id);
        if(authorOptional.isEmpty()){
            throw new ResourceNotFoundException("Author Id is invalid");
        }
        Author author = authorOptional.get();

        // step 2. fetch the object of member
        Optional<Member> optionalMember = memberRepository.getMemberById(member_id);
        if(optionalMember.isEmpty()){
            throw new ResourceNotFoundException("Member Id is invalid");
        }
        Member member = optionalMember.get();

        // step 3. create the book class with a full object

        book.setAuthor(author);
        book.setMember(member);

        //step 4.pass the book object to dao
        bookRepository.insert(book);

    }

    @Transactional
    public Book findBookById(int bookId) {
        Optional<Book> optionalBook = bookRepository.findBookById(bookId);
        if(optionalBook.isEmpty()){
            throw new ResourceNotFoundException("Book Id is invalid");
        }
        return optionalBook.get();
    }

    @Transactional
    public List<BookDTO> fetchAllBooks() {
        return bookRepository.fetchAllBooks();
    }
}
