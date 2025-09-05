package com.gestion_academica.dtos;

import java.time.LocalDateTime;
import java.time.Period;
import com.gestion_academica.entities.Student;

public class StudentDTO {
    private Long studentId;
    private String studentName;
    private String studentEmail;
    private String studentAddress;
    private int age;

    public StudentDTO(Student student) {
        this.studentId = student.getStudentId();
        this.studentName = student.getStudentName();
        this.studentEmail = student.getStudentEmail();
        this.studentAddress = student.getStudentAddress();
        this.age = calculateAge(student.getStudentBirthday());
    }

    private int calculateAge(LocalDateTime birthday) {
        if (birthday == null) return 0;
        return Period.between(birthday.toLocalDate(), LocalDateTime.now().toLocalDate()).getYears();
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

    public String getStudentAddress() {
        return studentAddress;
    }

    public void setStudentAddress(String studentAddress) {
        this.studentAddress = studentAddress;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}