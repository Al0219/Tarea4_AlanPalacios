package com.gestion_academica.dtos;

import com.gestion_academica.entities.Course;

public class CourseDTO {
    private Long courseId;
    private String courseName;
    private String courseDescription;
    // No incluimos student_state

    public CourseDTO(Course course) {
        this.courseId = course.getCourseId();
        this.courseName = course.getCourseName();
        this.courseDescription = course.getCourseDescription();
        // No asignamos student_state
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }
}