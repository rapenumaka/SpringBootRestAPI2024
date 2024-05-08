package com.amex.app.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Table(name="STUDENT") // This class is mapped to the table named customer
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long studentId;

    @Column(name = "NAME")
    private  String name;

    @Column(name = "DATE_OF_BIRTH")
    private  LocalDate dataOfBirth;

    @Column(name = "JOINING_DATE")
    private LocalDate dateOfJoining;

    @Column(name = "CLASS")
    private  String studentClass;




}
