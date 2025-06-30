package com.example.repository;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {
    public void saveBook(String title){
        System.out.println("Book Saved Title: " + title);
    }
}
