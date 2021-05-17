package org.example.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users", schema = "bookmanager")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

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

    @ElementCollection
    @OneToMany(targetEntity=Comment.class, mappedBy = "user", cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    private Collection<Comment> comments;

    public Collection<Comment> getComments() {
        return comments;
    }

    public void setComments(Collection<Comment> comments) {
        this.comments = comments;
    }

 //   private Set<Book> userBooks = new HashSet<>();

    public User(String username, String login, String password, String mail) {
        this.username = username;
        this.login = login;
        this.password = password;
        this.mail = mail;

    }
    public User() { }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User that = (User) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (login != null ? !login.equals(that.login) : that.login != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (mail != null ? !mail.equals(that.mail) : that.mail != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (mail != null ? mail.hashCode() : 0);
        return result;
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
