package com.springrest.entities;

public class CourseException extends RuntimeException  {

    private static final long serialVersionUID = 1L ;

    public CourseException(String message) {
        super(message);
    }

    public CourseException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
