package com.example.springDataJpa.repository;

import com.example.springDataJpa.model.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface StudentRepository extends CrudRepository<Student, Long> {


}
