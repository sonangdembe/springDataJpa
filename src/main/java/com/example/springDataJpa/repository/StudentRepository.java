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

    @Query("select s from Student s where s.age Between:min and :max")
    List<Student> findAgeGreaterThen(@Param("min") int min, @Param("max") int max);

    @Query("select s from Student s order by s.age ASC")
    List<Student> findByASC();

    @Query("select s from Student s where s.age > :age and s.name = :name")
    List<Student> findByAgeAndName(@Param("age") int age, @Param("name") String name);

    @Query("select count(s) from Student s")
    Long countByStudent();

    @Query("select s from Student s where s.name = :name")
    List<Student> findByName(@Param("name") String name);

    @Query("select s from Student s where s.age = :age")
    List<Student> findByAge(@Param("age") int age);
}
