package com.training_project.training_project.controller;

import com.training_project.training_project.custom_exception.DepartmentNotFoundException;
import com.training_project.training_project.custom_exception.EmployeeNotFoundException;
import com.training_project.training_project.model.Employee;
import com.training_project.training_project.model.ResponseException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@RestController
@ControllerAdvice
public class ResponseExceptionController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> globalResponseExceptionHandler(Exception exception, WebRequest request) {
        ResponseException exc = new ResponseException(exception.getMessage(), request.getDescription(false), new Date());
        return new ResponseEntity<Object>(exc, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<Object> handleEmployeeNotFoundException(EmployeeNotFoundException exception, WebRequest request) {
        ResponseException responseException = new ResponseException(exception.getMessage(), request.getDescription(false), new Date());
        return new ResponseEntity<Object>(responseException, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DepartmentNotFoundException.class)
    public ResponseEntity<Object> handleDepartmentNotFoundException(DepartmentNotFoundException exception, WebRequest request) {
        ResponseException responseException = new ResponseException(exception.getMessage(), request.getDescription(false), new Date());
        return new ResponseEntity<Object>(responseException, HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ResponseException responseException = new ResponseException("Invalid Data", request.getDescription(false), new Date());
        return new ResponseEntity<Object>(responseException, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
