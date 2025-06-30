package org.example;

import com.library.service.BookService;
import org.springframework.context.*;
import org.springframework.context.support.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world! My first Spring Project \n");

        // Load Spring context from XML file
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Get the BookService bean created by Spring
        BookService bookService = (BookService) context.getBean("bookService");

        // Test the dependency injection
        bookService.addBook("The Magic Tree House");

    }
}