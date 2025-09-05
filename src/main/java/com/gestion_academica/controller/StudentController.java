package com.gestion_academica.controller;

import com.gestion_academica.dtos.StudentDTO;
import com.gestion_academica.entities.Student;
import com.gestion_academica.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@CrossOrigin(origins = "*")
public class StudentController {

    private final StudentService studentService;

    // GET /api/students?name=algo
    @GetMapping
    public List<StudentDTO> getAll(@RequestParam(required = false) String name) {
        return studentService.findAllDTO(name);
    }

    // GET /api/students/{id}
    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> getById(@PathVariable Long id) {
        try {
            StudentDTO dto = studentService.obtenerStudentPorId(id);
            return ResponseEntity.ok(dto);
        } catch (RuntimeException ex) {
            return ResponseEntity.notFound().build();
        }
    }
    
    // Inyección por constructor
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // POST /api/students
    @PostMapping
    public ResponseEntity<Student> create(@RequestBody Student student) {
        return ResponseEntity.ok(studentService.create(student));
    }

    // PUT /api/students/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Student> update(@PathVariable Long id, @RequestBody Student studentDetails) {
        try {
            return ResponseEntity.ok(studentService.update(id, studentDetails));
        } catch (RuntimeException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE /api/students/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        try {
            studentService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException ex) {
            return ResponseEntity.notFound().build();
        }
    }
}
