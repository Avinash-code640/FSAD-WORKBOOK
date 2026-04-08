package com.klu.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.klu.model.Student;
import com.klu.repository.StudentRepository;

@Service
public class StudentService {

    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public Student addStudent(Student s) {
        return repository.save(s);
    }

    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    public Student getStudentById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Student updateStudent(Long id, Student s) {
        s.setId(id);
        return repository.save(s);
    }

    public void deleteStudent(Long id) {
        repository.deleteById(id);
    }
}