package com.company.springExam.repository;

import com.company.springExam.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
List<Student>findAllByFullName(String fullName);
}
