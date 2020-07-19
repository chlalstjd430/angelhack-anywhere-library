package com.anglehack.anywhereLibrary.domain.seat.exception;

import com.anglehack.anywhereLibrary.exception.NotFoundException;

public class SeatDoesNotExistException extends NotFoundException {
    public SeatDoesNotExistException() {
        this("The seat does not exist");
    }

    public SeatDoesNotExistException(String message) {
        super(message);
    }
}
