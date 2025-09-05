package com.gestion_academica.service;

import com.gestion_academica.dtos.StudentDTO;
import com.gestion_academica.entities.Student;
import com.gestion_academica.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public List<StudentDTO> findAllDTO(String studentName) {
        List<Student> students;
        if (studentName != null && !studentName.isEmpty()) {
            students = studentRepository.findByStudentNameContainingIgnoreCase(studentName);
        } else {
            students = studentRepository.findAll();
        }
        return students.stream().map(StudentDTO::new).collect(Collectors.toList());
    }

    public StudentDTO obtenerStudentPorId(Long studentId) {
        Student student = studentRepository.findById(studentId)
            .orElseThrow(() -> new RuntimeException("Student not found with id " + studentId));
        return new StudentDTO(student);
    }

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
                    student.setStudentName(studentDetails.getStudentName());
                    student.setStudentEmail(studentDetails.getStudentEmail());
                    student.setStudentBirthday(studentDetails.getStudentBirthday());
                    student.setStudentAddress(studentDetails.getStudentAddress());
                    student.setStudentState(studentDetails.isStudentState());
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