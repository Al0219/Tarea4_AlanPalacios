package com.gestion_academica.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gestion_academica.entities.Student;
public interface StudentRepository extends JpaRepository<Student, Long> {
    
}
