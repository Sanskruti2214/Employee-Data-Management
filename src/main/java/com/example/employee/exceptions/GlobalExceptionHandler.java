package com.example.employee.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.validation.ConstraintViolationException;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<String> handleEmployeeNotFound(EmployeeNotFoundException ex){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
	}
	
	@ExceptionHandler(DuplicateEmailException.class)
	public ResponseEntity<String> handleDuplicateEmail(DuplicateEmailException ex){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<String> handleValidationExceptions(MethodArgumentNotValidException ex) {
	    String errors = ex.getBindingResult()
	                      .getFieldErrors()
	                      .stream()
	                      .map(err -> err.getField() + ": " + err.getDefaultMessage())
	                      .reduce("", (a, b) -> a + b + "; ");
	    return ResponseEntity.badRequest().body(errors);
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<String> handleConstraintViolation(ConstraintViolationException ex) {
	    String errors = ex.getConstraintViolations()
	                      .stream()
	                      .map(v -> v.getPropertyPath() + ": " + v.getMessage())
	                      .reduce("", (a, b) -> a + b + "; ");
	    return ResponseEntity.badRequest().body(errors);
	}
	
	// fallback for other exceptions
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGeneralException(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                             .body("Something went wrong: " + ex.getMessage());
    }
	
}
