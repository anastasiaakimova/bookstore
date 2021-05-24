package org.example.model;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "books", schema = "bookmanager")
public class Book extends AbstractEntity {
    @Basic
    @Column(name = "book_title", nullable = true, length = 255)
    private String bookTitle;

    @Basic
    @Column(name = "book_author", nullable = true, length = 255)
    private String bookAuthor;

    @Basic
    @Column(name = "book_price", nullable = true)
    private int bookPrice;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(targetEntity = Comment.class, mappedBy = "book", cascade = {CascadeType.ALL}, orphanRemoval = true)
    private Collection<Comment> comments;

    public Collection<Comment> getComments() {
        return comments;
    }

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(targetEntity=Orders.class, mappedBy = "book", cascade = {CascadeType.ALL})
    private Collection<Orders> orders;

    public void setComments(Collection<Comment> comments) {
        this.comments = comments;
    }

    public Book(String bookTitle, String bookAuthor, int bookPrice) {
    }

    public Book() {
    }

    public Book(String book) {
    }

    public Book(Long id, String book) {
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public int getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(int bookPrice) {
        this.bookPrice = bookPrice;
    }

    @Override
    public String toString() {
        return "Book" +
                "id: " + id +
                ", bookTitle: " + bookTitle +
                ", bookAuthor: " + bookAuthor +
                ", bookPrice: " + bookPrice;
    }
}
