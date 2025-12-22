package com.jackalcode.resident_management_system.exception;

public class ResidentNotFoundException extends RuntimeException {

    public ResidentNotFoundException(String message) {
        super(message);
    }
}
