package com.example.springDataJpa.controller;

import com.example.springDataJpa.model.Student;
import com.example.springDataJpa.service.StudentService;
import org.apache.coyote.Response;
import org.springframework.data.repository.query.Param;
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

//    @GetMapping("age/{min}/{max}")
//    public ResponseEntity<List<Student>> getStudentByAge(@PathVariable int min, @PathVariable int max){
//        List<Student> student = studentService.findAgeGreaterThen(min, max);
//        return ResponseEntity.ok(student);
//    }

//    @GetMapping("/age")
//    public ResponseEntity<List<Student>> getStudent() {
//        List<Student> students = studentService.findByASC();
//        return ResponseEntity.ok(students);
//    }

//    @GetMapping("/{age}/{name}")
//    public ResponseEntity<List<Student>> getStudentByName(@PathVariable int age, @PathVariable String name){
//        List<Student> students = studentService.findByAgeAndName(age, name);
//        return ResponseEntity.ok(students);
//    }

    @GetMapping("/count")
    public ResponseEntity<Long> countStudent(){
        Long totalCount = studentService.countUsingStudent();
        return ResponseEntity.ok(totalCount);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<Student>> findByName(@PathVariable String name){
        List<Student> student = studentService.findByName(name);
        return ResponseEntity.ok(student);
    }


    @GetMapping("/age/{age}")
    public ResponseEntity<List<Student>> findByAge(@PathVariable int age){
        List<Student> student = studentService.findByAge(age);
        return ResponseEntity.ok(student);
    }
}
