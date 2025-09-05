package com.gestion_academica.controller;

import com.gestion_academica.dtos.TeacherDTO;
import com.gestion_academica.entities.Teacher;
import com.gestion_academica.service.TeacherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teachers")
@CrossOrigin(origins = "*")
public class TeacherController {

    private final TeacherService teacherService;

    // GET /api/teachers?name=algo
    @GetMapping
    public List<TeacherDTO> getAll(@RequestParam(required = false) String name) {
        return teacherService.findAllDTO(name);
    }

    // GET /api/teachers/{id}
    @GetMapping("/{id}")
    public ResponseEntity<TeacherDTO> getById(@PathVariable Long id) {
        try {
            TeacherDTO dto = teacherService.obtenerTeacherPorId(id);
            return ResponseEntity.ok(dto);
        } catch (RuntimeException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    // Inyección por constructor
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    // POST /api/teachers
    @PostMapping
    public ResponseEntity<Teacher> create(@RequestBody Teacher teacher) {
        return ResponseEntity.ok(teacherService.create(teacher));
    }

    // PUT /api/teachers/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Teacher> update(@PathVariable Long id, @RequestBody Teacher teacherDetails) {
        try {
            return ResponseEntity.ok(teacherService.update(id, teacherDetails));
        } catch (RuntimeException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE /api/teachers/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        try {
            teacherService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException ex) {
            return ResponseEntity.notFound().build();
        }
    }
}
