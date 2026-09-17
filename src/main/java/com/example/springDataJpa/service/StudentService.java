package com.example.springDataJpa.service;


import com.example.springDataJpa.model.Student;
import com.example.springDataJpa.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
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


    // update using id
    public void updateStudent(Student studentReq, Long id){
        Optional<Student> students = studentRepository.findById(id);

     Student student = students.get();
        student.setName(studentReq.getName());
        student.setAge(studentReq.getAge());
        student.setEmail(studentReq.getEmail());

    }

    // update using email
    public Student updateStudent(Student studentReq, String email) {

        Optional<Student> students = studentRepository.findByEmail(email);

        Student student = students.get();

        student.setName(studentReq.getName());
        student.setAge(studentReq.getAge());
        student.setEmail(studentReq.getEmail());

        studentRepository.save(student);

        return student;
    }

    public List<Student>  findAgeGreaterThen(int min, int max){
     return studentRepository.findAgeGreaterThen(min, max);
    }

    public List<Student> findByASC(){
        return studentRepository.findByASC();
    }

    public List<Student> findByAgeAndName(int age, String name){
        return studentRepository.findByAgeAndName(age, name);
    }

    public Long countUsingStudent(){
        return studentRepository.countByStudent();
    }

    public List<Student> findByName(String name){
        return studentRepository.findByName(name);
    }

    public List<Student> findByAge(int age){
        return studentRepository.findByAge(age);
    }
}
