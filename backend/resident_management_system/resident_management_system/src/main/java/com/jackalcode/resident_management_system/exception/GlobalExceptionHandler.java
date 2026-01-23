package com.jackalcode.resident_management_system.exception;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.jackalcode.resident_management_system.resident.Resident;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResidentAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ApiError handleResidentAlreadyExistsException(ResidentAlreadyExistsException ex, HttpServletRequest request) {

        return new ApiError("RESIDENT_ALREADY_EXIST", ex.getMessage(), request.getRequestURI());
    }

    @ExceptionHandler(ResidentNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiError handleResidentNotFoundException(ResidentNotFoundException ex, HttpServletRequest request) {

        return new ApiError("RESIDENT_NOT_FOUND", ex.getMessage(), request.getRequestURI());
    }

    @ExceptionHandler(CareInteractionNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiError handleCareInteractionNotFoundException(CareInteractionNotFoundException ex, HttpServletRequest request) {

        return new ApiError("CARE_INTERACTION_NOT_FOUND", ex.getMessage(), request.getRequestURI());
    }

    @ExceptionHandler(SupportPlanAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ApiError handleSupportPlanAlreadyExistsException(SupportPlanAlreadyExistsException ex, HttpServletRequest request) {

        return new ApiError("SUPPORT_PLAN_ALREADY_EXISTS", ex.getMessage(), request.getRequestURI());
    }

    @ExceptionHandler(SupportPlanNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiError handleSupportPlanNotFoundException(SupportPlanNotFoundException ex, HttpServletRequest request) {

        return new ApiError("SUPPORT_PLAN_NOT_FOUND", ex.getMessage(), request.getRequestURI());
    }

    @ExceptionHandler(AppUserAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ApiError handleAppUserAlreadyExistsException(AppUserAlreadyExistsException ex, HttpServletRequest request) {

        return new ApiError("USER_ALREADY_EXIST", ex.getMessage(), request.getRequestURI());
    }

    @ExceptionHandler(AppUserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiError handleAppUserNotFoundException(AppUserNotFoundException ex, HttpServletRequest request) {

        return new ApiError("USER_NOT_FOUND", ex.getMessage(), request.getRequestURI());
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatusCode status,
                                                                  WebRequest request) {
        List<ObjectError> errorList = ex.getBindingResult().getAllErrors();
        List<ApiError> errors = new ArrayList<>();

        errorList.forEach(
                (error) -> {
                    String fieldName = ((FieldError) error).getField();
                    String message = error.getDefaultMessage();
                    String code = fieldName.toUpperCase() + "_INVALID";
                    errors.add(new ApiError(code, message, request.getDescription(false)));
                }
        );
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(
            HttpMessageNotReadableException ex,
            HttpHeaders headers,
            HttpStatusCode status,
            WebRequest request) {

        ApiError error = new ApiError("INVALID_VALUE", ex.getMessage(), request.getContextPath());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiError handleGeneralException(Exception ex, HttpServletRequest request) {

        return new ApiError("BAD_REQUEST", ex.getMessage(), request.getRequestURI());
    }
}
