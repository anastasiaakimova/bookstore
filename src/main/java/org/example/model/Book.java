package org.example.model;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "books", schema = "bookmanager")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book that = (Book) o;

        if (bookPrice != that.bookPrice) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (bookTitle != null ? !bookTitle.equals(that.bookTitle) : that.bookTitle != null) return false;
        if (bookAuthor != null ? !bookAuthor.equals(that.bookAuthor) : that.bookAuthor != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (bookTitle != null ? bookTitle.hashCode() : 0);
        result = 31 * result + (bookAuthor != null ? bookAuthor.hashCode() : 0);
        result = 31 * result + bookPrice;
        return result;
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
