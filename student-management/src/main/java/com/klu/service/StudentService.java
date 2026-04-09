package com.klu.service;

import org.springframework.stereotype.Service;
import java.util.List;

import com.klu.model.Student;
import com.klu.repository.StudentRepository;

@Service
public class StudentService {

    private final StudentRepository repo;

    public StudentService(StudentRepository repo) {
        this.repo = repo;
    }

    // Add
    public Student addStudent(Student s) {
        return repo.save(s);
    }

    // Get All
    public List<Student> getAllStudents() {
        return repo.findAll();
    }

    // Update
    public Student updateStudent(Long id, Student s) {
        Student existing = repo.findById(id).orElseThrow();
        existing.setName(s.getName());
        existing.setEmail(s.getEmail());
        existing.setCourse(s.getCourse());
        return repo.save(existing);
    }

    // Delete
    public void deleteStudent(Long id) {
        repo.deleteById(id);
    }
}
