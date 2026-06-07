package com.schoolmanagement.student.service;

import com.schoolmanagement.student.model.Student;
import com.schoolmanagement.student.repository.StudentRepository;

import org.springframework.stereotype.Service;

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
