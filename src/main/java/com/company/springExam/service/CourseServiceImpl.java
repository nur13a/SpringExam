package com.company.springExam.service;

import com.company.springExam.entity.Course;
import com.company.springExam.model.CourseModel;
import com.company.springExam.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<Course> getAll() {
        return courseRepository.findAll();
    }

    @Override
    public Course getById(Long id) {
        Optional<Course> course = courseRepository.findById(id);
        return course.get();
    }

    @Override
    public void deleteById(Long id) {
        Course course = getById(id);
        if (course!=null)
        courseRepository.delete(course);
        throw new RuntimeException("not found Course");
    }

    @Override
    public Course create(CourseModel course) {
        return Course.builder().name(course.getName()).build();
    }
}
