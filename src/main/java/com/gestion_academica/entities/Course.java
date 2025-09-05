package com.gestion_academica.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_seq")
    @SequenceGenerator(name = "course_seq", sequenceName = "course_seq", allocationSize = 1)
    private Long courseId;

    @Column(name = "course_name", nullable = false)
    private String courseName;

    @Column(name = "course_description", nullable = false)
    private String courseDescription; 

    @Column(name = "course_state", nullable = false)
    private boolean courseState;

    public Course() {
    }

    public Course(Long courseId, String courseName, String courseDescription, boolean courseState) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseDescription = courseDescription;
        this.courseState = courseState;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long course_id) {
        this.courseId = course_id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String course_name) {
        this.courseName = course_name;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public boolean isCourseState() {
        return courseState;
    }

    public void setCourseState(boolean courseState) {
        this.courseState = courseState;
    }

}
