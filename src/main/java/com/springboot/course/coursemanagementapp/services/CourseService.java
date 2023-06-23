package com.springboot.course.coursemanagementapp.services;
import com.springboot.course.coursemanagementapp.entities.Course;

import java.util.List;

public interface CourseService {

    public List<Course> getCourses();

    Course getCourse(long id);

    Course addCourse(Course course);

    Course updateCourse(Course course);

    void deleteCourse(long courseID);
}