package com.Prajapati.StudentRegistrationAPI.Student.Registration.API.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Prajapati.StudentRegistrationAPI.Student.Registration.API.DTO.StudentDTO;
import com.Prajapati.StudentRegistrationAPI.Student.Registration.API.Service.StudentService;

import lombok.RequiredArgsConstructor;

@RequestMapping("/students")
@RestController
@RequiredArgsConstructor
public class StudentController {
 private final StudentService studentService;

@GetMapping("/allstudent")
 public List<StudentDTO> getAllStudents() {
        return studentService.getAllStudent();
    }

    @GetMapping("/{id}")
    public StudentDTO getBYID(@PathVariable Long id) {
        return studentService.getByID(id);
    }
  
    @PostMapping("/createstudent")
    public StudentDTO createStudent(@RequestBody StudentDTO studentDTO) {
        return studentService.createStudent(studentDTO);
    }
     @PostMapping("/updatestudent/{id}")
    public StudentDTO updateStudent( @PathVariable Long id, @RequestBody StudentDTO studentDTO) {
        return studentService.updateStudent(id, studentDTO);
    }
}
