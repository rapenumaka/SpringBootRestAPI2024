package com.amex.app.mapper;

import com.amex.app.dto.StudentDto;
import com.amex.app.entity.Student;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class StudentMapper {


    public static StudentDto toStudentDto(Student student) {
        System.out.println(student.toString());
        StudentDto studentDto = new StudentDto();
        studentDto.setStudentId(student.getStudentId());
        studentDto.setName(student.getName());
        studentDto.setDateOfBirth(student.getDataOfBirth().format(DateTimeFormatter.ofPattern("MM-dd-yyyy")));
        studentDto.setDateOfJoining(student.getDateOfJoining().format(DateTimeFormatter.ofPattern("MM-dd-yyyy")));
        studentDto.setStudentClass(student.getStudentClass());

        return studentDto;
    }


    public static Student toStudent(StudentDto studentDto) {

        Student student = new Student();

        student.setStudentId(studentDto.getStudentId());
        student.setName(studentDto.getName());
        student.setStudentClass(studentDto.getStudentClass());
        student.setDataOfBirth(LocalDate.parse(studentDto.getDateOfBirth(), DateTimeFormatter.ofPattern("MM-dd-yyyy")));
        student.setDateOfJoining(LocalDate.parse(studentDto.getDateOfJoining(), DateTimeFormatter.ofPattern("MM-dd-yyyy")));


        return student;
    }
}
