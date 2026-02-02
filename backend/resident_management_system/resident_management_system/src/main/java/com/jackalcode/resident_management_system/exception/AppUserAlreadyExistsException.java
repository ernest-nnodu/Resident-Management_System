package com.jackalcode.resident_management_system.exception;

public class AppUserAlreadyExistsException extends RuntimeException {

    public AppUserAlreadyExistsException(String message) {
        super(message);
    }
}
