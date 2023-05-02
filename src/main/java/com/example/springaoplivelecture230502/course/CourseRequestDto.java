package com.example.springaoplivelecture230502.course;

import lombok.Getter;

@Getter
public class CourseRequestDto {
    private String title;
    private String instructor;
    private Double cost;

    public CourseRequestDto(String title, String instructor, Double cost) {
        this.title = title;
        this.instructor = instructor;
        this.cost = cost;
    }
}
