package com.library.model;

import com.library.enums.Genre;
import com.library.enums.Status;
import jakarta.persistence.*;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false , length = 255)
    private String title;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Genre genre;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    @Column(nullable = false , name = "published_year")
    private int publishedYear;

    @ManyToOne
    @JoinColumn(name = "author_id" , nullable = false)
    private Author author;

    @ManyToOne
    @JoinColumn(name = "borrowed_by" )
    private Member member;

    public Book() {
    }

    public Book(long id, String title, Genre genre, Status status, int publishedYear, Author author, Member member) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.status = status;
        this.publishedYear = publishedYear;
        this.author = author;
        this.member = member;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getPublishedYear() {
        return publishedYear;
    }

    public void setPublishedYear(int publishedYear) {
        this.publishedYear = publishedYear;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", genre=" + genre +
                ", status=" + status +
                ", publishedYear=" + publishedYear +
                ", author=" + author +
                ", member=" + member +
                '}';
    }
}
