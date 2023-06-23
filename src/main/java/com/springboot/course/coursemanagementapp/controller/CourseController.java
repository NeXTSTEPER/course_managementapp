package com.springboot.course.coursemanagementapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.springboot.course.coursemanagementapp.entities.Course;
import com.springboot.course.coursemanagementapp.services.CourseService;

import java.util.List;

@Controller
public class CourseController {

    @Autowired
    private CourseService courseService;

    // Starting an app
    @RequestMapping("/welcome")
    public String home(){
        return "home";
    }

    @GetMapping("/courses")
    public String getCourses(Model model){
        model.addAttribute("courses", this.courseService.getCourses());
        return "courses";
    }

    @GetMapping("/courses/add")
    public String showAddCourseForm(Model model) {
        model.addAttribute("course", new Course());
        return "add-course";
    }

    @PostMapping("/courses")
    public String addCourse(@ModelAttribute Course course) {
        courseService.addCourse(course);
        return "redirect:/courses";
    }

    @GetMapping("/courses/edit/{id}")
    public String showEditCourseForm(@PathVariable("id") long id, Model model) {
        Course course = courseService.getCourse(id);
        model.addAttribute("course", course);
        return "edit-course";
    }

    @PostMapping("/courses/{id}")
    public String updateCourse(@PathVariable("id") long id, @ModelAttribute Course course) {
        // Here we would update the course
        course.setId(id);
        courseService.updateCourse(course);
        return "redirect:/courses";
    }

    @GetMapping("/courses/{courseID}")
    public Course getCourseFromID(@PathVariable String courseID){
        return this.courseService.getCourse(Long.parseLong(courseID));
    }

    @DeleteMapping("/courses/{courseID}")
    public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseID){
        try{
            this.courseService.deleteCourse(Long.parseLong(courseID));
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
