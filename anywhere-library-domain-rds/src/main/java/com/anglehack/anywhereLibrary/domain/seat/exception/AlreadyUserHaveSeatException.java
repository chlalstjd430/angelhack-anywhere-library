package com.anglehack.anywhereLibrary.domain.seat.exception;

import com.anglehack.anywhereLibrary.exception.ConflictException;

public class AlreadyUserHaveSeatException extends ConflictException {
    public AlreadyUserHaveSeatException() {
        this("already user have seat");
    }

    public AlreadyUserHaveSeatException(String message) {
        super(message);
    }
}