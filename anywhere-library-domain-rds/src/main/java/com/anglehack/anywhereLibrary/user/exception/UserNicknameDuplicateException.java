package com.anglehack.anywhereLibrary.user.exception;

import com.anglehack.anywhereLibrary.exception.ConflictException;

public class UserNicknameDuplicateException extends ConflictException {
    public UserNicknameDuplicateException() {
        this("user nickname is duplicated");
    }

    public UserNicknameDuplicateException(String message) {
        super(message);
    }
}