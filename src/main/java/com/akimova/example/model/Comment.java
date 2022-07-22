package com.akimova.example.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Data
@Table(name = "comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Basic
    @Column(name = "text", nullable = false)
    private String text;

    @ManyToOne
    private User user;

    @ManyToOne
    private Book book;

    @Override
    public String toString() {
        return "Comment by:"
                + getUser() +
                ", to book: " + getBook() +
                "\nText:" + text;
    }
}