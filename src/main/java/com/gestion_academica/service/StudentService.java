package com.gestion_academica.service;

import com.gestion_academica.entities.Student;
import com.gestion_academica.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    // Inyección por constructor
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // Listar todos
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    // Buscar por ID
    public Optional<Student> findById(Long id) {
        return studentRepository.findById(id);
    }

    // Crear
    public Student create(Student student) {
        return studentRepository.save(student);
    }

    // Actualizar
    public Student update(Long id, Student studentDetails) {
        return studentRepository.findById(id)
                .map(student -> {
                    student.setStudent_name(studentDetails.getStudent_name());
                    student.setStudent_email(studentDetails.getStudent_email());
                    student.setStudent_birthday(studentDetails.getStudent_birthday());
                    student.setStudent_address(studentDetails.getStudent_address());
                    student.setStudent_state(studentDetails.isStudent_state());
                    return studentRepository.save(student);
                })
                .orElseThrow(() -> new RuntimeException("Student not found with id " + id));
    }

    // Eliminar
    public void delete(Long id) {
        if (!studentRepository.existsById(id)) {
            throw new RuntimeException("Student not found with id " + id);
        }
        studentRepository.deleteById(id);
    }
}