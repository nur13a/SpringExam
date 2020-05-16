package com.company.springExam.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @Column(name = "name")
    String name;
}
