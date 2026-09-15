package com.example.springDataJpa.repository;

import com.example.springDataJpa.model.Student;
import org.springframework.data.repository.Repository;

import java.util.Optional;


public interface StudentRepository extends Repository<Student, Long> {

    void save(Student student);

    Optional<Student> findById(Long id);
}
