package com.gestion_academica.repositories;

import com.gestion_academica.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findByCourseNameContainingIgnoreCase(String courseName);
}