package com.company.springExam.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name="menu")
public class Menu {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    Long id;

    @CreatedDate
    @Column(name="createdDate")
    Date date=new Date();

    @Column(name="code")
    String code;
}
