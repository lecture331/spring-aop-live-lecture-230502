package com.example.springaoplivelecture230502.course;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Locale;

@Service
public class CourseService {

    private final CourseRepository courseRepository;
    private final MessageSource messageSource;

    public CourseService(CourseRepository courseRepository, MessageSource messageSource) {
        this.courseRepository = courseRepository;
        this.messageSource = messageSource;
    }

    public Course saveCourse(CourseRequestDto requestDto) {
        Course course = new Course(requestDto);
        return courseRepository.save(course);
    }

    public List<Course> getCourseList() {
        return courseRepository.findAll();
    }

    @Transactional
    public Course updateCourse(CourseRequestDto requestDto, Long id) {
        Course course = courseRepository.findById(id).orElseThrow(
                () -> new CourseNotFoundException(messageSource.getMessage(
                        "course.not.found",
                        null,
                        "Not Found",
                        Locale.getDefault()
                ))
        );

        course.update(requestDto);

        return course;
    }


    public String deleteCourse(String instructor) {
        Course course = courseRepository.findByInstructor(instructor).orElseThrow(
                () -> new CourseNotFoundException(
                        messageSource.getMessage(
                                "course.not.found.instructor",
                                new String[]{instructor},
                                "Not Found",
                                Locale.getDefault()
                        )
                )
        );
        courseRepository.delete(course);
        return "Delete Success";
    }
}