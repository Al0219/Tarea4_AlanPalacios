package com.gestion_academica.service;

import com.gestion_academica.entities.Teacher;
import com.gestion_academica.repositories.TeacherRepository;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

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
                    t.setTeacher_name(teacherDetails.getTeacher_name());
                    t.setTeacher_email(teacherDetails.getTeacher_email());
                    t.setTeacher_phone(teacherDetails.getTeacher_phone());
                    t.setTeacher_birthday(teacherDetails.getTeacher_birthday());
                    t.setTeacher_address(teacherDetails.getTeacher_address());
                    t.setTeacher_state(teacherDetails.isTeacher_state());
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
}
