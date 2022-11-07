package com.springrest.repository;


import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.springrest.entities.Course;

public interface CourseRepository extends MongoRepository < Course, String  > {

	public Optional<Course> findByName(String name);

}
