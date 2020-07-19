package com.anglehack.anywhereLibrary.domain.library.exception;

import com.anglehack.anywhereLibrary.exception.ConflictException;

public class LibraryNameDuplicateException extends ConflictException {
    public LibraryNameDuplicateException() {
        this("library name is duplicated");
    }

    public LibraryNameDuplicateException(String message) {
        super(message);
    }
}