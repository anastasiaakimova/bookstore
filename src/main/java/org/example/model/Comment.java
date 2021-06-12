package org.example.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "comment", schema = "bookmanager", catalog = "")
public class Comment extends AbstractEntity {

    @Basic
    @Column(name = "id_user", nullable = true)
    private Long idUser;
    @Basic
    @Column(name = "id_book", nullable = true)
    private Long idBook;

    @Basic
    @Column(name = "text", nullable = true, length = -1)
    private String text;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "id_user", referencedColumnName = "id", insertable = false, updatable = false)
    private User user;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "id_book", referencedColumnName = "id", insertable = false, updatable = false)
    private Book book;

    public Comment() {
    }

    public Comment(String comment) {
    }

    public Comment(Long id, String comment) {
    }

    public Comment(String text, String book) {
    }

    public Comment(String id_book, String id_user, String text) {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBooksByIdBook() {
        return book;
    }

    public void setBooksByIdBook(Book booksByIdBook) {
        this.book = booksByIdBook;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public Long getIdBook() {
        return idBook;
    }

    public void setIdBook(Long idBook) {
        this.idBook = idBook;
    }

   public String getText() {
        return text;
    }

    public void setText(String commentText) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Comment by:"
                + getUser() +
                ", to book: " + getBooksByIdBook() +
                "\nText:" + text;
    }
}