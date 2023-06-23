package com.springboot.course.coursemanagementapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springboot.course.coursemanagementapp.dao.CourseDao;
import com.springboot.course.coursemanagementapp.entities.Course;

import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;


@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseDao courseDao;
    
    @Autowired
    public CourseServiceImpl(CourseDao courseDao) {
        this.courseDao = courseDao;
    }

    @Override
    public List<Course> getCourses() {
        return courseDao.findAll();
    }

    @Override
    public Course getCourse(long id) {
        Optional<Course> courseOptionalObject = courseDao.findById(id);
        if(courseOptionalObject.isPresent())
            return courseOptionalObject.get();
        else
            return null;
    }

    @Override
    @Transactional
    public Course addCourse(Course course) {
        courseDao.save(course);
        return course;
    }

    @Override
    @Transactional
    public Course updateCourse(Course course) {
        courseDao.save(course);
        return course;
    }

    @Override
    @Transactional
    public void deleteCourse(long courseID) {
        Course course = courseDao.findById(courseID).get();
        courseDao.delete(course);

    }
}