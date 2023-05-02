package com.example.springaoplivelecture230502.course;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class CourseServiceTest {

    @Autowired
    CourseService courseService;

    @Test
    @DisplayName("Before, After 테스트")
    public void beforeAfterTest() {
        CourseRequestDto requestDto = new CourseRequestDto("Spring AOP", "Robbie", 1010101010.0);
        courseService.saveCourse(requestDto);
    }

    @Test
    @DisplayName("Around 테스트")
    public void aroundTest() {
        courseService.getCourseList();
    }

    @Test
    @DisplayName("AfterReturning 테스트")
    public void afterReturningTest() {
        courseService.deleteCourse("Robbie");
    }

    @Test
    @DisplayName("AfterThrowing 테스트")
    public void afterThrowingTest() {
        assertThrows(CourseNotFoundException.class, () -> {courseService.deleteCourse("bin");});
    }

}