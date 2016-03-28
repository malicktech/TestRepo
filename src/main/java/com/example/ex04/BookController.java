package com.example.ex04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @RequestMapping("/service/books")
    public @ResponseBody
    Iterable<Book> getAllBooks() {
        return this.bookRepository.findAll();
    }
    
    @RequestMapping(value="/service/book/{id}", method=RequestMethod.GET)
    public @ResponseBody Book getBookById(@PathVariable Long id) {
        return this.bookRepository.findOne(id);
    }
}
