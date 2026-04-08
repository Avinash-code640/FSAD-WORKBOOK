package com.klu.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

// ✅ Swagger Import
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Student Entity representing student details")
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Schema(description = "Unique ID of the student", example = "1")
    private Long id;

    @NotBlank(message = "Name cannot be empty")
    @Schema(description = "Name of the student", example = "Avinash")
    private String name;

    @Email(message = "Invalid email format")
    @Schema(description = "Email of the student", example = "avinash@gmail.com")
    private String email;

    @NotBlank(message = "Course cannot be empty")
    @Schema(description = "Course enrolled by student", example = "B.Tech")
    private String course;

    // Constructors
    public Student() {}

    public Student(Long id, String name, String email, String course) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.course = course;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getCourse() { return course; }
    public void setCourse(String course) { this.course = course; }
}