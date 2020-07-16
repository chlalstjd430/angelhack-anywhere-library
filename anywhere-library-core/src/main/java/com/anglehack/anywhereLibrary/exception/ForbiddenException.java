package com.anglehack.anywhereLibrary.exception;

public class ForbiddenException extends CanHaveStatusException{

    public ForbiddenException(){
        this("Forbidden Exception");
    }
    public ForbiddenException(String message) {
        super(403, message);
    }
}
