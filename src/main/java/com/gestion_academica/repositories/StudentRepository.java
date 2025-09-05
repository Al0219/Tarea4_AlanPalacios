package com.gestion_academica.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gestion_academica.entities.Student;
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByStudentNameContainingIgnoreCase(String studentName);
}
