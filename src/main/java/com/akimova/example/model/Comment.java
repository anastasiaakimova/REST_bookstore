package com.akimova.example.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Data
@Table(name = "comment")
public class Comment extends AbstractEntity{

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

}