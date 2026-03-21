package com.klu.controller;

import java.util.*;

import org.springframework.web.bind.annotation.*;

import com.klu.entity.Student;
import com.klu.exception.StudentNotFoundException;
import com.klu.exception.InvalidInputException;

@RestController
@RequestMapping("/student")
public class StudentController {

    // Dummy data
    private static List<Student> students = List.of(
            new Student(1, "Avinash", "CSE"),
            new Student(2, "Ravi", "ECE")
    );

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable String id) {

        int studentId;

        try {
            studentId = Integer.parseInt(id);
        } catch (Exception e) {
            throw new InvalidInputException("Invalid ID format. Please enter a number.");
        }

        return students.stream()
                .filter(s -> s.getId() == studentId)
                .findFirst()
                .orElseThrow(() -> new StudentNotFoundException("Student not found with ID: " + studentId));
    }
}