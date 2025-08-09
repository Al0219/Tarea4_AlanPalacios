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
    private Long course_id;

    @Column(name = "course_name", nullable = false)
    private String course_name;

    @Column(name = "course_description", nullable = false)
    private String course_description; 

    @Column(name = "course_state", nullable = false)
    private boolean course_state;

    public Course() {
    }

    public Course(Long course_id, String course_name, String course_description, boolean course_state) {
        this.course_id = course_id;
        this.course_name = course_name;
        this.course_description = course_description;
        this.course_state = course_state;
    }

    public Long getCourse_id() {
        return course_id;
    }

    public void setCourse_id(Long course_id) {
        this.course_id = course_id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getCourse_description() {
        return course_description;
    }

    public void setCourse_description(String course_description) {
        this.course_description = course_description;
    }

    public boolean isCourse_state() {
        return course_state;
    }

    public void setCourse_state(boolean course_state) {
        this.course_state = course_state;
    }

}
