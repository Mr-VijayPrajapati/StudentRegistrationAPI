package com.Prajapati.StudentRegistrationAPI.Student.Registration.API.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.Prajapati.StudentRegistrationAPI.Student.Registration.API.DTO.StudentDTO;
import com.Prajapati.StudentRegistrationAPI.Student.Registration.API.Entity.Student;
import com.Prajapati.StudentRegistrationAPI.Student.Registration.API.Repository.StudentRepository;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService{
    private final StudentRepository studentRepository;
    
    private StudentDTO mapTODTO(Student student){
        return new StudentDTO(student.getId(),student.getName(),student.getAge(),student.getFatherName(),student.getMotherName(),student.getMobileNo(),student.getEmail(),student.getCourse());
        
    }

    private Student mapToEntity(StudentDTO studentDTO){
        Student student =new Student();
        student.setId(studentDTO.getId());
        student.setName(studentDTO.getName()); 
        student.setAge(studentDTO.getAge());
        student.setFatherName(studentDTO.getFatherName());
        student.setMotherName(studentDTO.getMotherName());
        student.setMobileNo(studentDTO.getMobileNo());
        student.setEmail(studentDTO.getEmail());
        student.setCourse(studentDTO.getCourse());
        return student;
    
    }
    @Override
    public List<StudentDTO> getAllStudent() {
     return studentRepository.findAll().stream().map(this :: mapTODTO).collect(Collectors.toList());
}

    @Override
    public StudentDTO getByID(Long id) {
        Student student = studentRepository.findById(id).orElseThrow(()-> new RuntimeException("Student not found"));
        return mapTODTO(student);
    }

    @Override
    public StudentDTO createStudent(StudentDTO studentDTO) {
        Student student = mapToEntity(studentDTO);
        Student savedStudent = studentRepository.save(student);
        return mapTODTO(savedStudent);
    }

    @Override
    public StudentDTO updateStudent(Long id, StudentDTO studentDTO) {
        Student existingStudent = studentRepository.findById(id).orElseThrow(()-> new RuntimeException("Student not found"));
        existingStudent.setName(studentDTO.getName());
        existingStudent.setAge(studentDTO.getAge());
        existingStudent.setFatherName(studentDTO.getFatherName());
        existingStudent.setMotherName(studentDTO.getMotherName());
        existingStudent.setMobileNo(studentDTO.getMobileNo());
        existingStudent.setEmail(studentDTO.getEmail());
        existingStudent.setCourse(studentDTO.getCourse());
        Student updatedStudent = studentRepository.save(existingStudent);
        return mapTODTO(updatedStudent);
    }

}
