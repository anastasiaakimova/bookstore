package org.example.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "comment", schema = "bookmanager", catalog = "")
public class Comment  extends AbstractEntity{
//    private Long id;
    private Long idUser;
    private Long idBook;
    private String text;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "id_user", referencedColumnName = "id", insertable = false, updatable = false)
    private User user;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "id_book", referencedColumnName = "id", insertable = false, updatable = false)
    private Book book;

    public Comment() {}
    public Comment(String comment) {}
    public Comment(Long id, String comment) {}
    public Comment(String text, String book) {}
    public Comment(String id_book, String id_user, String text) {}

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

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id", nullable = false)
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }

    @Basic
    @Column(name = "id_user", nullable = true)
    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    @Basic
    @Column(name = "id_book", nullable = true)
    public Long getIdBook() {
        return idBook;
    }

    public void setIdBook(Long idBook) {
        this.idBook = idBook;
    }

    @Basic
    @Column(name = "text", nullable = true, length = -1)
    public String getText() {
        return text;
    }

    public void setText(String commentText) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return Objects.equals(id, comment.id) && Objects.equals(idUser, comment.idUser) && Objects.equals(idBook, comment.idBook)  && Objects.equals(text, comment.text) && Objects.equals(user, comment.user) && Objects.equals(book, comment.book);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idUser, idBook, text, user, book);
    }

    @Override
    public String toString() {
        return "Comment by:"
                + getUser() +
                ", to book: " + getBooksByIdBook() +
                "\nText:" + text;
    }
}