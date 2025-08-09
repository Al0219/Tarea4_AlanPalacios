package com.gestion_academica.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_seq")
    @SequenceGenerator(name = "student_seq", sequenceName = "student_seq", allocationSize = 1)
    private Long student_id;

    @Column(name = "student_name", nullable = false)
    private String student_name;

    @Column(name = "student_email", nullable = false, unique = true)
    private String student_email;

    @Column(name = "student_birthday", nullable = false)
    private LocalDateTime student_birthday;

    @Column(name = "student_address", nullable = false)
    private String student_address;

    @Column(name = "student_state", nullable = false)
    private boolean student_state;

    public Student() {
    }

    public Student(Long student_id, String student_name, String student_email, LocalDateTime student_birthday, String student_address, boolean student_state) {
        this.student_id = student_id;
        this.student_name = student_name;
        this.student_email = student_email;
        this.student_birthday = student_birthday;
        this.student_address = student_address;
        this.student_state = student_state;
    }

    public Long getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Long student_id) {
        this.student_id = student_id;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getStudent_email() {
        return student_email;
    }

    public void setStudent_email(String student_email) {
        this.student_email = student_email;
    }

    public LocalDateTime getStudent_birthday() {
        return student_birthday;
    }

    public void setStudent_birthday(LocalDateTime student_birthday) {
        this.student_birthday = student_birthday;
    }

    public String getStudent_address() {
        return student_address;
    }

    public void setStudent_address(String student_address) {
        this.student_address = student_address;
    }

    public boolean isStudent_state() {
        return student_state;
    }

    public void setStudent_state(boolean student_state) {
        this.student_state = student_state;
    }
}
