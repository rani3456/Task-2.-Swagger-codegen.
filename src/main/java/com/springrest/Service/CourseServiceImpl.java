package com.springrest.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springrest.entities.Course;
import com.springrest.entities.CourseException;
import com.springrest.repository.CourseRepository;

@Service
@Transactional

public class CourseServiceImpl implements CourseService{
    @Autowired
    private CourseRepository courseRepository;


    @Override
    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course updateCourse(Course course) {
        Optional < Course > courseDb = this.courseRepository.findById(course.getId());

        if (courseDb.isPresent()) {
        	Course courseUpdate = courseDb.get();
            courseUpdate.setId(course.getId());
            courseUpdate.setName(course.getName());
            courseUpdate.setDescription(course.getDescription());
            courseRepository.save(courseUpdate);
            return courseUpdate;
        } else {
            throw new CourseException("Record not found with id : " + course.getId());
        }
    }

    @Override
    public List < Course > getAllCourse() {
        return this.courseRepository.findAll();
        
    }

    @Override
    public Course getCourseById(String id) throws CourseException {
        Optional<Course> course = courseRepository.findById(id);
        if (course.isEmpty())
            throw new CourseException("Course not present");
        return course.get();
    }
    
    
    @Override
    public Course getCourseByName(String name) throws CourseException {
        Optional<Course> course = courseRepository.findByName(name);
        if (course.isPresent())
            return course.get();
        else
            throw new CourseException("Course not found");

}


    @Override
    public void deleteCourse(String courseId) {
        Optional < Course > courseDb = this.courseRepository.findById(courseId);

        if (courseDb.isPresent()) {
            this.courseRepository.delete(courseDb.get());
        } else {
            throw new CourseException("Record not found with id : " + courseId);
        }

    }

}





