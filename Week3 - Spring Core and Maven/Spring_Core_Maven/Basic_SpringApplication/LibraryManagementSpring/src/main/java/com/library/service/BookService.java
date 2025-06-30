package com.library.service;

import com.library.repository.BookRepository;

public class BookService {

    private BookRepository bookRepository;

    //Spring uses this method to inject the dependency
    public void setBookRepository(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    public void addBook(String title){
        System.out.println("Book added to library, Name: " + title);
        bookRepository.saveBook(title);
    }
}
