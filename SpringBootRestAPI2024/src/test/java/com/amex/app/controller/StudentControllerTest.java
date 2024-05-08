package com.amex.app.controller;

import com.amex.app.dto.StudentDto;
import com.amex.app.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(StudentController.class)
public class StudentControllerTest {

    @Autowired
     private MockMvc mockMvc;

     @MockBean
     private StudentService studentService;



     @Test
     public void testGetStudentById() throws Exception {
         StudentDto studentDto = new StudentDto();
         studentDto.setName("James Bond");
         studentDto.setStudentClass("Political Science");
         studentDto.setDateOfBirth("02-05-1978");
         studentDto.setDateOfJoining("03-25-2024");
         studentDto.setStudentId(1L);

         when(studentService.getStudentById(any(Long.class))).thenReturn(studentDto);

         mockMvc.perform(get("/api/v1//studentById?studentId=1"))
                 .andExpect(status().isOk())
                 .andExpect(jsonPath("$.name").value("James Bond"))
                 .andExpect(jsonPath("$.studentClass").value("Political Science"))
                 .andExpect(jsonPath("$.dateOfBirth").value("02-05-1978"))
                 .andExpect(jsonPath("$.dateOfJoining").value("03-25-2024"))
                 .andExpect(jsonPath("$.studentId").value(1L));
     }

     @Test
     public void testCreateStudent() throws Exception {

         StudentDto studentDto = new StudentDto();
         studentDto.setName("James Bond");
         studentDto.setStudentClass("Political Science");
         studentDto.setDateOfBirth("02-05-1978");
         studentDto.setDateOfJoining("03-25-2024");
         studentDto.setStudentId(1L);

         when(studentService.createStudent(any(StudentDto.class))).thenReturn(studentDto);

         mockMvc.perform(post("/api/v1/createstudent")
          .contentType(MediaType.APPLICATION_JSON)
                 .content("{\n" +
                         "  \"name\": \"James Bond\",\n" +
                         "  \"studentClass\": \"Political Science\",\n" +
                         "  \"dateOfBirth\": \"02-05-1978\",\n" +
                         "  \"dateOfJoining\": \"03-25-2024\"\n" +
                         "}"))
                 .andExpect(status().isCreated())
                 .andExpect(jsonPath("$.studentId").exists()).
                  andExpect(jsonPath("$.name").value("James Bond"))
                 .andExpect(jsonPath("$.studentClass").value("Political Science"));
     }

     @Test
     public void testUpdateStudent() throws Exception {

         StudentDto studentDto = new StudentDto();
         studentDto.setName("Stephen Squeri");
         studentDto.setStudentClass("MBA Financial Management");
         studentDto.setDateOfBirth("02-05-1959");
         studentDto.setDateOfJoining("03-25-2020");
         studentDto.setStudentId(1L);


         when(studentService.updateStudent(any(Long.class),any(StudentDto.class))).thenReturn(studentDto);

         mockMvc.perform(put("/api/v1/student?studentId=1")
          .contentType(MediaType.APPLICATION_JSON)
                         .content("{\n" +
                                 "  \"name\": \"James Bond\",\n" +
                                 "  \"studentClass\": \"Political Science\",\n" +
                                 "  \"dateOfBirth\": \"02-05-1978\",\n" +
                                 "  \"dateOfJoining\": \"03-25-2024\"\n" +
                                 "}"))
                 .andExpect(status().is2xxSuccessful())
                 .andExpect(jsonPath("$.studentId").exists()).
                 andExpect(jsonPath("$.name").value("Stephen Squeri"))
                 .andExpect(jsonPath("$.studentClass").value("MBA Financial Management"));

     }



     @Test
     public void testDeleteStudentById() throws Exception {

         when(studentService.deleteStudentById(any(Long.class))).thenReturn(true);

         mockMvc.perform(delete("/api/v1/deletestudent/{studentId}",1L)).andExpect(status().is2xxSuccessful());

     }

}
