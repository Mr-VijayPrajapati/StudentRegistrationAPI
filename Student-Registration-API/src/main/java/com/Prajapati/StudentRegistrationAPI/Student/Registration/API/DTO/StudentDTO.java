package com.Prajapati.StudentRegistrationAPI.Student.Registration.API.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {
     private Long id;
    private String name;
    private String age;
    private String FatherName;
    private String MotherName;
    private String MobileNo;
    private String email;
    private String course;
    
}

