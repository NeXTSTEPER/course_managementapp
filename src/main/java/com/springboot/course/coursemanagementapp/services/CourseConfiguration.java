package com.springboot.course.coursemanagementapp.services;
import com.springboot.course.coursemanagementapp.dao.CourseDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CourseConfiguration {

    @Bean
    public CourseService courseService(CourseDao courseDao) {
        return new CourseServiceImpl(courseDao);
    }
}
