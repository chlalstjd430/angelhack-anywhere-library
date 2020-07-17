package com.anglehack.anywhereLibrary.auth.exception;


import com.anglehack.anywhereLibrary.exception.ForbiddenException;

public class TokenIsInvalidException extends ForbiddenException {
    public TokenIsInvalidException() {
        this("Token is invalid.");
    }

    public TokenIsInvalidException(String message) {
        super(message);
    }
}
