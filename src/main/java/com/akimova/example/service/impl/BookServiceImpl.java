package com.akimova.example.service.impl;


import com.akimova.example.model.Book;
import com.akimova.example.repo.BookRepo;
import com.akimova.example.service.GeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements GeneralService<Book> {
    @Autowired
    BookRepo bookRepo;

    @Override
    public void save(Book book) {
        bookRepo.save(book);
    }

    @Override
    public List<Book> findAll() {
        return bookRepo.findAll();
    }

    @Override
    public Book findById(Long id) {
        return bookRepo.findBookById(id);
    }

    @Override
    public void delete(Long id) {
        bookRepo.deleteById(id);
    }

    @Override
    public Book findByName(String title) {
        return bookRepo.findBookByTitle(title);
    }
}
