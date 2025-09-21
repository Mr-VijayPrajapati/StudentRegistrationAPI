package com.Prajapati.StudentRegistrationAPI.Student.Registration.API.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Prajapati.StudentRegistrationAPI.Student.Registration.API.Entity.Student;

public interface StudentRepository extends JpaRepository<Student,Long>{

}
