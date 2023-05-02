package com.example.springaoplivelecture230502.course;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(CourseNotFoundException.class)
    public ResponseEntity<?> courseNotFound(CourseNotFoundException ex) throws JsonProcessingException {
        String json = new ObjectMapper().writeValueAsString(new ExceptionResponseDto(ex.getMessage(), HttpStatus.NOT_FOUND.value()));
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(json);
    }
}
