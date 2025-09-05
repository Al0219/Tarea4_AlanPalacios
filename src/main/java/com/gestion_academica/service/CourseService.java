package com.gestion_academica.service;

import com.gestion_academica.dtos.CourseDTO;
import com.gestion_academica.entities.Course;
import com.gestion_academica.repositories.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    public List<CourseDTO> findAllDTO(String courseName) {
        List<Course> courses;
        if (courseName != null && !courseName.isEmpty()) {
            courses = courseRepository.findByCourseNameContainingIgnoreCase(courseName);
        } else {
            courses = courseRepository.findAll();
        }
        return courses.stream().map(CourseDTO::new).collect(Collectors.toList());
    }

    // Obtener CourseDTO por ID
    public CourseDTO obtenerCoursePorId(Long courseId) {
        Course course = courseRepository.findById(courseId)
            .orElseThrow(() -> new RuntimeException("Course not found with id " + courseId));
        return new CourseDTO(course);
    }

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
                    course.setCourseName(courseDetails.getCourseName());
                    course.setCourseDescription(courseDetails.getCourseDescription());
                    course.setCourseState(courseDetails.isCourseState());
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