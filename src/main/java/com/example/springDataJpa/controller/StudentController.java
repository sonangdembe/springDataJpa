package com.example.springDataJpa.controller;

import com.example.springDataJpa.model.Student;
import com.example.springDataJpa.service.StudentService;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")

public class StudentController {

    private StudentService studentService;
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @PostMapping
    public ResponseEntity<String> createStudent(@RequestBody Student student){
        studentService.createStudent(student);
        return ResponseEntity.ok("student created");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id){
     Student student = studentService.fetchStudentById(id);
     return ResponseEntity.ok(student);
    }

    @PutMapping("/{email}")
    public ResponseEntity<String> updateStudent(
            @PathVariable String email,
            @RequestBody Student student) {

        Student students = studentService.updateStudent(student, email);

        return ResponseEntity.ok("student updated");
    }

    @GetMapping("age/{age}")
    public ResponseEntity<List<Student>> getStudentByAge(@PathVariable int age){
        List<Student> student = studentService.findAgeGreaterThen(age);
        return ResponseEntity.ok(student);
    }

}
