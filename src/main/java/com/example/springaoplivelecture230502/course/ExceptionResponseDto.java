package com.example.springaoplivelecture230502.course;

import lombok.Getter;

@Getter
public class ExceptionResponseDto {
    private String message;
    private int statusCode;
    public ExceptionResponseDto(String message, int statusCode) {
        this.message = message;
        this.statusCode = statusCode;
    }
}
