package com.amex.app.service.impl;

import com.amex.app.dto.StudentDto;
import com.amex.app.entity.Student;
import com.amex.app.exception.NoStudentsFoundException;
import com.amex.app.exception.StudentNotFoundException;
import com.amex.app.mapper.StudentMapper;
import com.amex.app.repository.StudentRepository;
import com.amex.app.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {



    private StudentRepository studentRepository;

    public void setStudentRepository(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    @Override
    public StudentDto createStudent(StudentDto studentDto) {
        Student student = StudentMapper.toStudent(studentDto);
        Student savedStudent = this.studentRepository.save(student);
        return StudentMapper.toStudentDto(savedStudent);
    }

    @Override
    public StudentDto getStudentById(Long studentId) {
        Optional<Student> student = this.studentRepository.findById(studentId);

        if(student.isPresent()){
            return StudentMapper.toStudentDto(student.get());
        }else{
            throw new StudentNotFoundException(studentId);
        }
    }

    @Override
    public List<StudentDto> getStudentsByClass(String studentClass) {
        Optional<List<Student>> studentByStudentClass = studentRepository.findStudentByStudentClass(studentClass);
        return studentByStudentClass.map(students -> students.stream().map(StudentMapper::toStudentDto).collect(Collectors.toList())).orElseThrow(NoStudentsFoundException::new);

    }

    @Override
    public StudentDto getStudentsByName(String studentName) {
        Optional<Student> studentByName = studentRepository.findStudentByName(studentName);
        return studentByName.map(StudentMapper::toStudentDto).orElseThrow(()->new StudentNotFoundException(studentName));
    }

    @Override
    public StudentDto updateStudent(Long studentId, StudentDto studentDto) {
        Optional<Student> student = this.studentRepository.findById(studentId);

        if(student.isPresent()){
            Student updatedStudent = StudentMapper.toStudent(studentDto);
            Student updatedStudent2 = this.studentRepository.save(updatedStudent);
            return StudentMapper.toStudentDto(updatedStudent2);

        }else{
            throw new StudentNotFoundException(studentId);
        }


    }

    @Override
    public boolean deleteStudentById(Long studentId) {

        Optional<Student> student = this.studentRepository.findById(studentId);

        if(student.isPresent()){
             this.studentRepository.deleteById(studentId);
             return true;

        }else{
            throw new StudentNotFoundException(studentId);
        }

    }


    public List<StudentDto> fetchAllStudents(){
        return this.studentRepository.findAll().stream().map(StudentMapper::toStudentDto).collect(Collectors.toList());
    }
}
