package com.akimova.example.model;

import javax.persistence.*;
import java.util.List;

@Entity
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

    public Book() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "Book" +
                "id: " + id +
                ", bookTitle: " + title +
                ", bookAuthor: " + author +
                ", bookPrice: " + price;
    }
}
