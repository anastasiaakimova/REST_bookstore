package com.akimova.example.controller;

import com.akimova.example.model.Book;
import com.akimova.example.service.GeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Qualifier("bookServiceImpl")
    @Autowired
    GeneralService generalService;

    @RequestMapping(value = "/book/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Book> getBookById(@PathVariable("id") Long Id) {
        if (Id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Book book = (Book) this.generalService.findById(Id);

        if (book == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @RequestMapping(value = "/book/{title}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Book> getBookByTitle(@RequestParam(value = "title") String title) {
        if (title == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Book book = (Book) this.generalService.findByName(title);

        if (book == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @RequestMapping(value = "/book", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Book> saveBook(@RequestBody Book book) {
        HttpHeaders headers = new HttpHeaders();

        if (book == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.generalService.save(book);
        return new ResponseEntity<>(book, headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/book/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Book> deleteBook(@PathVariable("id") Long id) {
        Book book = (Book) this.generalService.findById(id);

        if (book == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        this.generalService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/books", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = this.generalService.findAll();

        if (books.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(books, HttpStatus.OK);
    }
}
