package com.jackalcode.resident_management_system.exception;

public class AppUserNotFoundException extends RuntimeException {

    public AppUserNotFoundException(String message) {
        super(message);
    }
}
