package com.anglehack.anywhereLibrary.api.library.exception;


import com.anglehack.anywhereLibrary.exception.NotFoundException;

public class LibraryDoesNotExistException extends NotFoundException {
    public LibraryDoesNotExistException() {
        this("library does not exist");
    }

    public LibraryDoesNotExistException(String message) {
        super(message);
    }
}
