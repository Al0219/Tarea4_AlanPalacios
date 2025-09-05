package com.gestion_academica.controller;

import com.gestion_academica.dtos.CourseDTO;
import com.gestion_academica.entities.Course;
import com.gestion_academica.service.CourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
@CrossOrigin(origins = "*")
public class CourseController {

    private final CourseService courseService;

    // GET /api/courses?name=algo
    @GetMapping
    public List<CourseDTO> getAll(@RequestParam(required = false) String name) {
        return courseService.findAllDTO(name);
    }

    // GET /api/courses/{id}
    @GetMapping("/{id}")
    public ResponseEntity<CourseDTO> getById(@PathVariable Long id) {
        try {
            CourseDTO dto = courseService.obtenerCoursePorId(id);
            return ResponseEntity.ok(dto);
        } catch (RuntimeException ex) {
            return ResponseEntity.notFound().build();
        }
    }
    // Inyección de dependencias por constructor
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    // POST /api/courses
    @PostMapping
    public ResponseEntity<Course> create(@RequestBody Course course) {
        return ResponseEntity.ok(courseService.create(course));
    }

    // PUT /api/courses/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Course> update(@PathVariable Long id, @RequestBody Course courseDetails) {
        try {
            return ResponseEntity.ok(courseService.update(id, courseDetails));
        } catch (RuntimeException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE /api/courses/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        try {
            courseService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException ex) {
            return ResponseEntity.notFound().build();
        }
    }
}