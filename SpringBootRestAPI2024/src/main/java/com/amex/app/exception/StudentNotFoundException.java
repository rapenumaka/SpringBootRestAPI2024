package com.amex.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class StudentNotFoundException extends RuntimeException{

    public StudentNotFoundException(Long studentId){
        super("Student with id: " + studentId + " not found");
    }

}

