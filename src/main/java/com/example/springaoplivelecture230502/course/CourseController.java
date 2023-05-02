package com.example.springaoplivelecture230502.course;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/course")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @DeleteMapping("/{instructor}")
    public void deleteCourse(@PathVariable String instructor) {
        courseService.deleteCourse(instructor);
    }
}
