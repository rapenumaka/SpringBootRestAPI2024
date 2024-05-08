package com.amex.app.controller;

import com.amex.app.dto.StudentDto;
import com.amex.app.exception.ErrorResponseDto;
import com.amex.app.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping(path = "/api/v1", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
@Validated
public class StudentController {


    private StudentService studentService;



    @GetMapping(value = "/health-check")
    public String healthCheck(){
        return "OK";
    }


    @Operation(
            summary = "Get Student by studentId",
            description = "Get Student by studentId"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status OK"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    }
    )
    @GetMapping(value = "/student")
    public ResponseEntity<StudentDto> getStudent(@Valid @RequestParam  Long studentId) {

       return ResponseEntity.status(HttpStatus.OK)
               .body(this.studentService.getStudentById(studentId));
    }


    @Operation(
            summary = "Get all Students",
            description = "Get all Students"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status OK"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    }
    )
    @GetMapping(value = "/students")
    public CompletableFuture<ResponseEntity<List<StudentDto>>> getAllStudents() {

        CompletableFuture<ResponseEntity<List<StudentDto>>> completedFuture = CompletableFuture.
                completedFuture(
                        ResponseEntity.accepted().
                                body(this.studentService.fetchAllStudents())
                ).toCompletableFuture();
        return completedFuture;
    }


    @Operation(
            summary = "Delete Student",
            description = "Delete Student by studentId"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status OK"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    }
    )
    @DeleteMapping("/deletestudent/{studentId}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long studentId) {
        boolean isRemoved = this.studentService.deleteStudentById(studentId);
        if (isRemoved) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Operation(
            summary = "Create the Student",
            description = "Create the Student"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status OK"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    }
    )
    @PostMapping(value = "/createstudent")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<StudentDto> createStudent(@Valid @RequestBody  StudentDto studentDto) {

        return ResponseEntity.status(HttpStatus.CREATED).body(this.studentService.createStudent(studentDto));


    }


    @Operation(
            summary = "Update the Student",
            description = "Update the Student"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status OK"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    }
    )
    @PutMapping(value = "/student")
    public ResponseEntity<StudentDto> updateStudent(@RequestParam(value = "studentId", required = true)
                                                        Long studentId, @Valid @RequestBody StudentDto studentDto) {

       return ResponseEntity.accepted().body(this.studentService.updateStudent(studentId,studentDto));
    }






}
