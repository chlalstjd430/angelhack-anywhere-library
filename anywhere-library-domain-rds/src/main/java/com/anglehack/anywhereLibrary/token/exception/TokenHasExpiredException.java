package com.anglehack.anywhereLibrary.token.exception;

import com.anglehack.anywhereLibrary.exception.ForbiddenException;

public class TokenHasExpiredException extends ForbiddenException {
    public TokenHasExpiredException() {
        this("Token has expired");
    }

    public TokenHasExpiredException(String message) {
        super(message);
    }
}
