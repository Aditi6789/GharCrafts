package com.gharcraft.controller;

import org.springframework.http.*;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String,String>> badRequest(IllegalArgumentException ex){return ResponseEntity.badRequest().body(Map.of("error",ex.getMessage()));}
    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<Map<String,String>> unauthorized(IllegalStateException ex){return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("error",ex.getMessage()));}
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> validation(MethodArgumentNotValidException ex){return ResponseEntity.badRequest().body(Map.of("error","Please check the submitted details. Password must be at least 6 characters."));}
}
