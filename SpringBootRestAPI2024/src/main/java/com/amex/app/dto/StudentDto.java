package com.amex.app.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Nonnull;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;

@Data
@Schema(
        name = "Student",
        description = "Schema to hold Student information"
)

@NoArgsConstructor
public class StudentDto {

    public StudentDto( String name, String studentClass, String dateOfBirth, String dateOfJoining ){
        this.name = name;
        this.studentClass = studentClass;
        this.dateOfBirth = dateOfBirth;
        this.dateOfJoining = dateOfJoining;
    }

    @Schema(
            description = "Student ID", example = "007"
    )
    private Long studentId;


    @Schema(
            description = "Name", example = "James Bond"
    )
    @NotEmpty(message = "Student name can't be empty")
    private String name;


    @Schema(
            description = "Class", example = "Political Science"
    )
    @NotEmpty(message = "Student class cannot be empty")
    private String studentClass;



    @NotEmpty(message = "Student date of birth cannot be empty")
    @Pattern(regexp = "^(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01])-((?:19|20)[0-9][0-9])$", message = "Date of birth should be in mm-DD-yyyy format")
    private String dateOfBirth;


   @NotEmpty(message = "Student date of joining cannot be empty")
   @Pattern(regexp = "^(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01])-((?:19|20)[0-9][0-9])$", message = "Date of joining should be in mm-DD-yyyy format")
    private String dateOfJoining;






}
