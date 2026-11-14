package com.springboot.training.filemanager.controller;

public class BookNotFoundException extends RuntimeException {


    public BookNotFoundException(){
        
    }
    public BookNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
    // ...
}
