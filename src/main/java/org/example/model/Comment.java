package org.example.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "comment", schema = "bookmanager", catalog = "")
public class Comment {
    private Long id;
    private Long idUser;
    private Long idBook;
    private String text;
    private User usersByIdUser;
    private Book bookByIdBook;
    public Comment() {
    }

    public Comment(String comment) {
    }

    public Comment(Long id, String comment) {
    }

    public Comment(String text, String bookByIdBook) {

    }

    public Comment(String id_book, String id_user, String text) {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public Collection<Comment> getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
        return Objects.equals(id, comment.id) && Objects.equals(idUser, comment.idUser) && Objects.equals(idBook, comment.idBook)  && Objects.equals(text, comment.text) && Objects.equals(usersByIdUser, comment.usersByIdUser) && Objects.equals(bookByIdBook, comment.bookByIdBook);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idUser, idBook, text, usersByIdUser, bookByIdBook);
    }

    @ManyToOne
    @JoinColumn(name = "id_User", referencedColumnName = "id", insertable = false, updatable = false)
    public User getUsersByIdUser() {
        return usersByIdUser;
    }

    public void setUsersByIdUser(User usersByIdUser) {
        this.usersByIdUser = usersByIdUser;
    }

    @ManyToOne
    @JoinColumn(name = "id_book", referencedColumnName = "id", insertable = false, updatable = false)
    public Book getBooksByIdBook() {
        return bookByIdBook;
    }

    public void setBooksByIdBook(Book booksByIdBook) {
        this.bookByIdBook = booksByIdBook;
    }

    @Override
    public String toString() {
        return "Comment by:"
                + getUsersByIdUser() +
                ", to book: " + getBooksByIdBook() +
                "\nText:" + text;
    }

}
