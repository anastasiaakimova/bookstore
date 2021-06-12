package org.example.model;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users", schema = "bookmanager")
public class User extends AbstractEntity {

    @Basic
    @Column(name = "username", nullable = true, length = 255)
    private String username;

    @Basic
    @Column(name = "login", nullable = true, length = 255)
    private String login;

    @Basic
    @Column(name = "password", nullable = true, length = 255)
    private String password;

    @Basic
    @Column(name = "mail", nullable = true, length = 255)

    private String mail;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(targetEntity=Comment.class, mappedBy = "user", cascade = {CascadeType.ALL})
    private Collection<Comment> comments;

    public Collection<Comment> getComments() {
        return comments;
    }

    public void setComments(Collection<Comment> comments) {
        this.comments = comments;
    }

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(targetEntity=Orders.class, mappedBy = "user", cascade = {CascadeType.ALL})
    private Collection<Orders> orders;

    //   private Set<Book> userBooks = new HashSet<>();

    public User(String username, String login, String password, String mail) {
        this.username = username;
        this.login = login;
        this.password = password;
        this.mail = mail;

    }
    public User() { }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public String toString() {
        return "User " +
                "id:" + id +
                ", username:" + username +
                ", login:" + login +
                ", password:" + password +
                ", mail:" + mail;
    }
}
