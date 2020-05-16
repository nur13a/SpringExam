package com.company.springExam.controller;

import com.company.springExam.entity.Course;
import com.company.springExam.model.CourseModel;
import com.company.springExam.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("student")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping
    public ResponseEntity getAll() {
        try {
            List<Course> all = courseService.getAll();
            return new ResponseEntity<>(all, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable("id") Long id) {
        try{
            Course course=courseService.getById(id);
            return new ResponseEntity<>(course,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    public ResponseEntity create(@RequestBody CourseModel course) {
        try {
            Course course1 = courseService.create(course);
            return new ResponseEntity<>(course1, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {
        courseService.deleteById(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
