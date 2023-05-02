package com.example.springaoplivelecture230502.course;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String instructor;
    private Double cost;

    public Course(String title, String instructor, Double cost) {
        this.title = title;
        this.instructor = instructor;
        this.cost = cost;
    }

    public Course(CourseRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.instructor = requestDto.getInstructor();
        this.cost = requestDto.getCost();
    }

    public void update(CourseRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.instructor = requestDto.getInstructor();
        this.cost = requestDto.getCost();
    }
}