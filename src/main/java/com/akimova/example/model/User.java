package com.akimova.example.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
@Data
public class User extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Basic
    @Column(name = "username", nullable = false)
    private String username;

    @Basic
    @Column(name = "password", nullable = false)
    private String password;

    @Basic
    @Column(name = "email", nullable = false)
    private String email;

    @OneToMany(targetEntity = Comment.class, mappedBy = "user")
    private List<Comment> comments;

    @OneToMany(targetEntity = Order.class, mappedBy = "user")
    private List<Order> orders;

    @Override
    public String toString() {
        return "User " +
                "id:" + id +
                ", username:" + username +
                ", password:" + password +
                ", email:" + email;
    }
}
