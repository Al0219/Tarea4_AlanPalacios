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
    private Long teacherId;

    @Column(name = "teacher_name", nullable = false)
    private String teacherName;
    @Column(name = "teacher_email", nullable = false, unique = true)
    private String teacherEmail;
    @Column(name = "teacher_phone", nullable = false, unique = true)
    private String teacherPhone;   
    @Column(name = "teacher_birthday", nullable = false)
    private LocalDateTime teacherBirthday;
    @Column(name = "teacher_address", nullable = false)
    private String teacherAddress;
    @Column(name = "teacher_state", nullable = false)  
    private boolean teacherState;

    public Teacher() {
    }

    public Teacher(Long teacherId, String teacherName, String teacherEmail, String teacherPhone, LocalDateTime teacherBirthday, String teacherAddress, boolean teacherState) {
        this.teacherId = teacherId;
        this.teacherName = teacherName;
        this.teacherEmail = teacherEmail;
        this.teacherPhone = teacherPhone;
        this.teacherBirthday = teacherBirthday;
        this.teacherAddress = teacherAddress;
        this.teacherState = teacherState;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherEmail() {
        return teacherEmail;
    }

    public void setTeacherEmail(String teacherEmail) {
        this.teacherEmail = teacherEmail;
    }

    public String getTeacherPhone() {
        return teacherPhone;
    }

    public void setTeacherPhone(String teacherPhone) {
        this.teacherPhone = teacherPhone;
    }

    public LocalDateTime getTeacherBirthday() {
        return teacherBirthday;
    }

    public void setTeacherBirthday(LocalDateTime teacherBirthday) {
        this.teacherBirthday = teacherBirthday;
    }

    public String getTeacherAddress() {
        return teacherAddress;
    }

    public void setTeacherAddress(String teacherAddress) {
        this.teacherAddress = teacherAddress;
    }

    public boolean isTeacherState() {
        return teacherState;
    }

    public void setTeacherState(boolean teacherState) {
        this.teacherState = teacherState;
    }

}
