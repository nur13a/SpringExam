package com.company.springExam.service;

import com.company.springExam.entity.Student;
import com.company.springExam.model.StudentModel;

import java.util.List;

public interface StudentService {
    List<Student> getAll();
    Student getById(Long id);
    void deleteById(Long id);
    Student create(StudentModel student);
    List<Student>findByName(String name);
}
