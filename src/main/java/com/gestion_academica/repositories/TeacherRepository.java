package com.gestion_academica.repositories;

import com.gestion_academica.entities.Teacher;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    List<Teacher> findByTeacherNameContainingIgnoreCase(String teacherName);
}
