package com.amex.app.cmd;

import com.amex.app.dto.StudentDto;
import com.amex.app.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class Runner implements CommandLineRunner {

    private StudentService studentService;


    @Override
    public void run(String... args) throws Exception {

        studentService.createStudent(new StudentDto("James Bond", "Political Science", "12-01-1989", "01-01-2025"));
        studentService.createStudent(new StudentDto("John Doe", "Computer Science", "12-01-1989", "01-01-2025"));
        studentService.createStudent(new StudentDto("Donald Trump", "MBA", "05-06-1947", "01-01-2025"));
        studentService.createStudent(new StudentDto("Mike Tyson", "MBA", "12-01-1963", "01-01-2025"));
        studentService.createStudent(new StudentDto("Joe Biden", "Political Science", "02-02-1939", "01-01-2025"));
        studentService.createStudent(new StudentDto("Justin Trudent", "Political Science", "12-22-1978", "01-01-2025"));
        studentService.createStudent(new StudentDto("John Oliver", "MBA", "07-01-1977", "01-01-2025"));




    }
}
