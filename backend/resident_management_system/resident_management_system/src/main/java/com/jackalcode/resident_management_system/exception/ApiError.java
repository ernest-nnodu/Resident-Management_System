package com.jackalcode.resident_management_system.exception;

import java.time.Instant;

public record ApiError(
        String code,
        String message,
        Instant timestamp,
        String path
) {
    public ApiError(String code, String message, String path) {
        this(code, message, Instant.now(), path);
    }
}
