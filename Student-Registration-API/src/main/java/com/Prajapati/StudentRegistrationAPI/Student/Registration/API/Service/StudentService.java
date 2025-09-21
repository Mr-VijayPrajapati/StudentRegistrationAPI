package com.Prajapati.StudentRegistrationAPI.Student.Registration.API.Service;

import java.util.List;

import com.Prajapati.StudentRegistrationAPI.Student.Registration.API.DTO.StudentDTO;

public interface StudentService {

    List<StudentDTO> getAllStudent();
    StudentDTO getByID(Long id);
    StudentDTO createStudent(StudentDTO studentDTO);
    StudentDTO updateStudent(Long id,StudentDTO studentDTO);
} 
