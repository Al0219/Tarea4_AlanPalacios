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
    private Long studentId;

    @Column(name = "student_name", nullable = false)
    private String studentName;

    @Column(name = "student_email", nullable = false, unique = true)
    private String studentEmail;

    @Column(name = "student_birthday", nullable = false)
    private LocalDateTime studentBirthday;

    @Column(name = "student_address", nullable = false)
    private String studentAddress;

    @Column(name = "student_state", nullable = false)
    private boolean studentState;

    public Student() {
    }

    public Student(Long studentId, String studentName, String studentEmail, LocalDateTime studentBirthday, String studentAddress, boolean studentState) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentEmail = studentEmail;
        this.studentBirthday = studentBirthday;
        this.studentAddress = studentAddress;
        this.studentState = studentState;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public LocalDateTime getStudentBirthday() {
        return studentBirthday;
    }

    public void setStudentBirthday(LocalDateTime studentBirthday) {
        this.studentBirthday = studentBirthday;
    }

    public String getStudentAddress() {
        return studentAddress;
    }

    public void setStudentAddress(String studentAddress) {
        this.studentAddress = studentAddress;
    }

    public boolean isStudentState() {
        return studentState;
    }

    public void setStudentState(boolean studentState) {
        this.studentState = studentState;
    }
}
