package com.anglehack.anywhereLibrary.api.user.exception;

import com.anglehack.anywhereLibrary.exception.NotFoundException;

public class UserDoesNotExistException extends NotFoundException {
    public UserDoesNotExistException() {
        this("user does not exist");
    }

    public UserDoesNotExistException(String message) {
        super(message);
    }
}