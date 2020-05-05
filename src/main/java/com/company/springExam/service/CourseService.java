package com.company.springExam.service;

import com.company.springExam.entity.Course;
import com.company.springExam.model.CourseModel;

import java.util.List;

public interface CourseService {
    List<Course> getAll();
    Course getById(Long id);
    void deleteById(Long id);
    Course create(CourseModel course);
}
