package com.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.Service.CourseService;
import com.springrest.entities.Course;
import com.springrest.entities.CourseException;


@RestController
@RequestMapping("/course")
@CrossOrigin
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping("/getAll")
    public ResponseEntity < List < Course >> getAllCourse() {
        return ResponseEntity.ok().body(courseService.getAllCourse());
    }

    @GetMapping("/get")
    public Course getCourses(@RequestParam(value = "id") String id) throws CourseException {
        return courseService.getCourseById(id);
    }
    
    @GetMapping("/getByName")
    public Course getCourse(@RequestParam(value = "name") String name) throws CourseException {
        return courseService.getCourseByName(name);
    }


    @PostMapping("/create")
    public ResponseEntity < Course > createCourse(@RequestBody Course course) {
        return ResponseEntity.ok().body(this.courseService.createCourse(course));
    }

    @PutMapping("/{id}")
    public ResponseEntity < Course > updateCourse(@PathVariable String  id, @RequestBody Course course) {
        course.setId(id);
        return ResponseEntity.ok().body(this.courseService.updateCourse(course));
    }

    @DeleteMapping("/delete/{id}")
    public HttpStatus deletecourse(@PathVariable String id) {
        this.courseService.deleteCourse(id);
        return HttpStatus.OK;
    }
}

