package com.amex.app.repository;

import com.amex.app.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {


    Optional<Student> findStudentByName(String name);

    Optional<List<Student>> findStudentByStudentClass(String studentClass);

}
