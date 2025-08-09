package com.gestion_academica.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gestion_academica.entities.Course;
public interface CourseRepository extends JpaRepository<Course, Long> {
}
