package com.example.springDataJpa.service;


import com.example.springDataJpa.model.Student;
import com.example.springDataJpa.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {

    StudentRepository studentRepository;
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void createStudent(Student student){
       studentRepository.save(student);
    }

    public Student fetchStudentById(Long id){
    Optional<Student> student  = studentRepository.findById(id);

    if(student.isPresent()){
        return student.get();
    }else {
        return null;
    }
    }
}
