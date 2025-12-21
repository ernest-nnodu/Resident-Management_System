package com.jackalcode.resident_management_system.exception;

public class ResidentAlreadyExistsException extends RuntimeException {

    public ResidentAlreadyExistsException(String message) {
        super(message);
    }
}
