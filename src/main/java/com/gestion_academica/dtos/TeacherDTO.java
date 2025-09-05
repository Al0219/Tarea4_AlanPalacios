package com.gestion_academica.dtos;

import java.time.LocalDateTime;
import java.time.Period;
import com.gestion_academica.entities.Teacher;

public class TeacherDTO {
    private Long teacherId;
    private String teacherName;
    private String teacherEmail;
    private String teacherPhone;
    private String teacherAddress;
    private int age;

    public TeacherDTO(Teacher teacher) {
        this.teacherId = teacher.getTeacherId();
        this.teacherName = teacher.getTeacherName();
        this.teacherEmail = teacher.getTeacherEmail();
        this.teacherPhone = teacher.getTeacherPhone();
        this.teacherAddress = teacher.getTeacherAddress();
        this.age = calculateAge(teacher.getTeacherBirthday());
    }

    private int calculateAge(LocalDateTime birthday) {
        if (birthday == null) return 0;
        return Period.between(birthday.toLocalDate(), LocalDateTime.now().toLocalDate()).getYears();
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

    public String getTeacherAddress() {
        return teacherAddress;
    }

    public void setTeacherAddress(String teacherAddress) {
        this.teacherAddress = teacherAddress;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}