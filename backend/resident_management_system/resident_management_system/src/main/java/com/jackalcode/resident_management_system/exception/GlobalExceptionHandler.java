package com.jackalcode.resident_management_system.exception;

import com.jackalcode.resident_management_system.resident.Resident;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResidentAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ApiError handleResidentAlreadyExistsException(ResidentAlreadyExistsException ex, HttpServletRequest request) {

        return new ApiError("RESIDENT_ALREADY_EXIST", ex.getMessage(), request.getRequestURI());
    }
}
