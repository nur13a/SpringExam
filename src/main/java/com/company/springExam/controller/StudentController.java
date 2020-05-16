package com.company.springExam.controller;

import com.company.springExam.entity.Student;
import com.company.springExam.model.StudentModel;
import com.company.springExam.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URLDecoder;
import java.util.List;

public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping
    public ResponseEntity getAll() {
        try {
            List<Student> all = studentService.getAll();
            return new ResponseEntity<>(all, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable("id") Long id) {
        try {
            Student student = studentService.getById(id);
            return new ResponseEntity<>(student, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    public ResponseEntity create(@RequestBody StudentModel studentModel) {
        try {
            Student student = studentService.create(studentModel);
            return new ResponseEntity<>(student, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {
        studentService.deleteById(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/find?fio={name}")
    public ResponseEntity getAllByName(@PathVariable("name") String name) {
        try {
            String encoded=name;
            String decoded= URLDecoder.decode(encoded,"UTF-8");
            List<Student> all = studentService.findByName(decoded);
            return new ResponseEntity<>(all, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
