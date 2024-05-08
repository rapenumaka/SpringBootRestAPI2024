package com.amex.app.service;

import com.amex.app.dto.StudentDto;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface StudentService {


    public StudentDto createStudent(StudentDto studentDto);

    public StudentDto getStudentById(Long studentId);

    public StudentDto updateStudent(Long studentId, StudentDto studentDto);

    public boolean deleteStudentById(Long studentId);

    public List<StudentDto> fetchAllStudents();
}
