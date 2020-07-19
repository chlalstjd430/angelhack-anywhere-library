package com.anglehack.anywhereLibrary.domain.user.exception;

import com.anglehack.anywhereLibrary.exception.UnauthorizedException;

public class PasswordDoesNotMatchException extends UnauthorizedException {
    public PasswordDoesNotMatchException() {
        this("password does not match");
    }

    public PasswordDoesNotMatchException(String message) {
        super(message);
    }
}
