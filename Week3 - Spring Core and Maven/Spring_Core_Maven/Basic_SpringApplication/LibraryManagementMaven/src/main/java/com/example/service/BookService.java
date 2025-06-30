package com.example.service;

import com.example.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private BookRepository bookRepository;

    private String serviceName;

    @Autowired
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook(String title){
        System.out.println( " [ " + serviceName + " ] " + "Book Added, title: " + title);
        bookRepository.saveBook(title);
    }

    // Constructor for injecting serviceName
    public BookService(String serviceName) {
        this.serviceName = serviceName;
    }
}
