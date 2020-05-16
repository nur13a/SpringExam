package com.company.springExam.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @Column(name = "fullName")
    String fullName;
    @ManyToOne
    @JoinColumn(name = "course_id")
    Course course;
    @CreatedDate
    @Column(name = "created_date")
    Date registrationDate = new Date();
    @Column(name = "amount")
    BigInteger amount;
}
