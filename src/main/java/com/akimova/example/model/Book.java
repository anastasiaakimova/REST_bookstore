package com.akimova.example.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Basic
    @Column(name = "title", nullable = false)
    private String title;
    @Basic
    @Column(name = "author", nullable = false)
    private String author;
    @Basic
    @Column(name = "price", nullable = false)
    private int price;

    @OneToMany(targetEntity = Comment.class, mappedBy = "book")
    private List<Comment> comments;

    @OneToMany(targetEntity = Order.class, mappedBy = "book")
    private List<Order> orders;

    @Override
    public String toString() {
        return "Book" +
                "id: " + id +
                ", bookTitle: " + title +
                ", bookAuthor: " + author +
                ", bookPrice: " + price;
    }
}
