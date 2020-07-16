package com.anglehack.anywhereLibrary.user.exception;

import com.anglehack.anywhereLibrary.exception.ConflictException;

public class UserIdentificationDuplicateException extends ConflictException {
    public UserIdentificationDuplicateException() {
        this("user identification is already exist");
    }

    public UserIdentificationDuplicateException(String message) {
        super(message);
    }
}