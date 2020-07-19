package com.anglehack.anywhereLibrary.domain.user.exception;

import com.anglehack.anywhereLibrary.exception.ConflictException;

public class UserIdentificationDuplicateException extends ConflictException {
    public UserIdentificationDuplicateException() {
        this("user identification is duplicated");
    }

    public UserIdentificationDuplicateException(String message) {
        super(message);
    }
}