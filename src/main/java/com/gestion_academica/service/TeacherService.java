package com.gestion_academica.service;

import com.gestion_academica.dtos.TeacherDTO;
import com.gestion_academica.entities.Teacher;
import com.gestion_academica.repositories.TeacherRepository;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TeacherService {

    private final TeacherRepository teacherRepository;


    // Inyección por constructor
    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    // Listar todos
    public List<Teacher> findAll() {
        return teacherRepository.findAll(); 
    }

    // Buscar por ID
    public Optional<Teacher> findById(Long id) {
        return teacherRepository.findById(id);
    }

    // Crear
    public Teacher create(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    // Actualizar
    public Teacher update(Long id, Teacher teacherDetails) {
        return teacherRepository.findById(id)
                .map(t -> {
                    t.setTeacherName(teacherDetails.getTeacherName());
                    t.setTeacherEmail(teacherDetails.getTeacherEmail());
                    t.setTeacherPhone(teacherDetails.getTeacherPhone());
                    t.setTeacherBirthday(teacherDetails.getTeacherBirthday());
                    t.setTeacherAddress(teacherDetails.getTeacherAddress());
                    t.setTeacherState(teacherDetails.isTeacherState());
                    return teacherRepository.save(t);
                })
                .orElseThrow(() -> new RuntimeException("Teacher not found with id " + id));
    }

    // Eliminar
    public void delete(Long id) {
        if (!teacherRepository.existsById(id)) {
            throw new RuntimeException("Teacher not found with id " + id);
        }
        teacherRepository.deleteById(id);
    }

    public List<TeacherDTO> findAllDTO(String teacherName) {
        List<Teacher> teachers;
        if (teacherName != null && !teacherName.isEmpty()) {
            teachers = teacherRepository.findByTeacherNameContainingIgnoreCase(teacherName);
        } else {
            teachers = teacherRepository.findAll();
        }
        return teachers.stream().map(TeacherDTO::new).collect(Collectors.toList());
    }

    public TeacherDTO obtenerTeacherPorId(Long teacher_id) {
        Teacher teacher = teacherRepository.findById(teacher_id)
            .orElseThrow(() -> new RuntimeException("Teacher not found with id " + teacher_id));
        return new TeacherDTO(teacher);
    }
}
