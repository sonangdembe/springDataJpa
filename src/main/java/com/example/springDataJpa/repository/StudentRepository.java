package com.example.springDataJpa.repository;

import com.example.springDataJpa.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


public interface StudentRepository extends JpaRepository<Student, Long> {

Optional<Student> findByEmail(String email);

@Query("select s from Student s where s.age <:age")
List<Student> findAgeGreaterThen(@Param("age") int age);
}
