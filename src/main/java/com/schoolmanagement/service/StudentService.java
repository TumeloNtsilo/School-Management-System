package com.schoolmanagement.service;

import com.schoolmanagement.model.Student;
import com.schoolmanagement.repository.StudentRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepo;

    public StudentService(StudentRepository studentRepo){
        this.studentRepo = studentRepo;
    }

    public String getStudentDetails(){
        return studentRepo.toString();
    }


    public void addNewStudent(Student newStudent){
        studentRepo.save(newStudent);
    }


}
