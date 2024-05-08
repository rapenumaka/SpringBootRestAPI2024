package com.amex.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class NoStudentsFoundException extends RuntimeException{

    public NoStudentsFoundException(){
        super("No students found");
    }
}
