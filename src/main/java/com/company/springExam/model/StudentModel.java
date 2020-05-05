package com.company.springExam.model;

import com.company.springExam.entity.Course;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigInteger;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class StudentModel {
    String fullName;
    Course courseId;
    BigInteger amount;
}
