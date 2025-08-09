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
@Table(name = "teacher")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "teacher_seq")
    @SequenceGenerator(name = "teacher_seq", sequenceName = "teacher_seq", allocationSize = 1)
    private Long teacher_id;

    @Column(name = "teacher_name", nullable = false)
    private String teacher_name;
    @Column(name = "teacher_email", nullable = false, unique = true)
    private String teacher_email;
    @Column(name = "teacher_phone", nullable = false, unique = true)
    private String teacher_phone;   
    @Column(name = "teacher_birthday", nullable = false)
    private LocalDateTime teacher_birthday;
    @Column(name = "teacher_address", nullable = false)
    private String teacher_address;
    @Column(name = "teacher_state", nullable = false)  
    private boolean teacher_state;

    public Teacher() {
    }

    public Teacher(Long teacher_id, String teacher_name, String teacher_email, String teacher_phone, LocalDateTime teacher_birthday, String teacher_address, boolean teacher_state) {
        this.teacher_id = teacher_id;
        this.teacher_name = teacher_name;
        this.teacher_email = teacher_email;
        this.teacher_phone = teacher_phone;
        this.teacher_birthday = teacher_birthday;
        this.teacher_address = teacher_address;
        this.teacher_state = teacher_state;
    }

    public Long getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(Long teacher_id) {
        this.teacher_id = teacher_id;
    }

    public String getTeacher_name() {
        return teacher_name;
    }

    public void setTeacher_name(String teacher_name) {
        this.teacher_name = teacher_name;
    }

    public String getTeacher_email() {
        return teacher_email;
    }

    public void setTeacher_email(String teacher_email) {
        this.teacher_email = teacher_email;
    }

    public String getTeacher_phone() {
        return teacher_phone;
    }

    public void setTeacher_phone(String teacher_phone) {
        this.teacher_phone = teacher_phone;
    }

    public LocalDateTime getTeacher_birthday() {
        return teacher_birthday;
    }

    public void setTeacher_birthday(LocalDateTime teacher_birthday) {
        this.teacher_birthday = teacher_birthday;
    }

    public String getTeacher_address() {
        return teacher_address;
    }

    public void setTeacher_address(String teacher_address) {
        this.teacher_address = teacher_address;
    }

    public boolean isTeacher_state() {
        return teacher_state;
    }

    public void setTeacher_state(boolean teacher_state) {
        this.teacher_state = teacher_state;
    }

}
