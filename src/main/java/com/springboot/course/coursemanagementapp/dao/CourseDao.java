package com.springboot.course.coursemanagementapp.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import com.springboot.course.coursemanagementapp.entities.Course;


public interface CourseDao extends JpaRepository<Course, Long> {
}