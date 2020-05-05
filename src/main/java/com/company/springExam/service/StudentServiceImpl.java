package com.company.springExam.service;

import com.company.springExam.entity.Course;
import com.company.springExam.entity.Student;
import com.company.springExam.model.StudentModel;
import com.company.springExam.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    CourseService courseService;

    @Override
    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student getById(Long id) {
        Optional<Student> student = studentRepository.findById(id);
        return student.get();
    }

    @Override
    public void deleteById(Long id) {
        Student student = getById(id);
        if (student != null)
            studentRepository.delete(student);
        throw new RuntimeException("not found student");//в идеале все ошибки должны быть прописаны нами
    }

    @Override
    public Student create(StudentModel student) {
        Course course = courseService.getById(student.getCourseId().getId());
        if (course != null) {
            Student student1 = Student.builder().fullName(student.getFullName())
                    .amount(student.getAmount())
                    .course(course)
                    .registrationDate(new Date()).build();
            return student1;
        }
        throw new RuntimeException("Course Not Found");
    }

    @Override
    public List<Student> findByName(String name) {
        List<Student> findByName = studentRepository.findAllByFullName(name);
        if (findByName != null) {
            return findByName;
        }
        throw new RuntimeException("not found nobody");
    }
}
