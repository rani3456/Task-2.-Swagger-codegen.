package com.springrest.Service;

import java.util.List;
import java.util.Optional;

import com.springrest.entities.Course;

public interface CourseService {

    Course createCourse(Course course);

    Course updateCourse(Course course);

    List < Course > getAllCourse();

    Course getCourseById(String courseId);

    void deleteCourse(String id);

	Course getCourseByName(String name);
}




