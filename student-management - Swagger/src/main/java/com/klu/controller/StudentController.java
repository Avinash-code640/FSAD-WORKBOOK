package com.klu.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.klu.model.Student;
import com.klu.service.StudentService;

// ✅ Swagger Imports
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/students")

// ✅ Main Swagger Tag
@Tag(name = "Student API", description = "CRUD operations for Student")
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    // ✅ POST
    @Operation(summary = "Add a new student")
    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody Student s) {
        return ResponseEntity.ok(service.addStudent(s));
    }

    // ✅ GET ALL
    @Operation(summary = "Get all students")
    @GetMapping
    public ResponseEntity<List<Student>> getAll() {
        return ResponseEntity.ok(service.getAllStudents());
    }

    // ❗ YOU MISSED THIS (important for lab)
    @Operation(summary = "Get student by ID")
    @GetMapping("/{id}")
    public ResponseEntity<Student> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getStudentById(id));
    }

    // ✅ UPDATE
    @Operation(summary = "Update student")
    @PutMapping("/{id}")
    public ResponseEntity<Student> update(@PathVariable Long id, @RequestBody Student s) {
        return ResponseEntity.ok(service.updateStudent(id, s));
    }

    // ✅ DELETE
    @Operation(summary = "Delete student")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        service.deleteStudent(id);
        return ResponseEntity.ok("Deleted Successfully");
    }
}