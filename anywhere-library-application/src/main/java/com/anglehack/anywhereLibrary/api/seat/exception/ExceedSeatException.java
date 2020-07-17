package com.anglehack.anywhereLibrary.api.seat.exception;

import com.anglehack.anywhereLibrary.exception.ForbiddenException;

public class ExceedSeatException extends ForbiddenException {
    public ExceedSeatException() {
        this("The seat has been exceed");
    }

    public ExceedSeatException(String message) {
        super(message);
    }
}
