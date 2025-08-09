package com.gestion_academica.service;

import com.gestion_academica.entities.Course;
import com.gestion_academica.repositories.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    // Inyección de dependencias por constructor
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    // Obtener todos los cursos
    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    // Obtener curso por ID
    public Optional<Course> findById(Long id) {
        return courseRepository.findById(id);
    }

    // Crear nuevo curso
    public Course create(Course course) {
        return courseRepository.save(course);
    }

    // Actualizar curso existente
    public Course update(Long id, Course courseDetails) {
        return courseRepository.findById(id)
                .map(course -> {
                    course.setCourse_name(courseDetails.getCourse_name());
                    course.setCourse_description(courseDetails.getCourse_description());
                    course.setCourse_state(courseDetails.isCourse_state());
                    return courseRepository.save(course);
                })
                .orElseThrow(() -> new RuntimeException("Course not found with id " + id));
    }

    // Eliminar curso
    public void delete(Long id) {
        if (!courseRepository.existsById(id)) {
            throw new RuntimeException("Course not found with id " + id);
        }
        courseRepository.deleteById(id);
    }
}