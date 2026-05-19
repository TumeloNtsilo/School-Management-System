package com.schoolmanagement.controller;

import com.schoolmanagement.model.Student;
import com.schoolmanagement.repository.StudentRepository;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Scanner;

@RestController
@RequestMapping("/students")
public class StudentController {
    private StudentRepository studentRepo;

    public StudentController(StudentRepository studentRepo){
        this.studentRepo = studentRepo;
    }

    @GetMapping
    public List<Student> getStudents(){
        return studentRepo.findAll();
    }

    @PostMapping
    public void modifyName(@RequestBody @Valid Student newStudent){
        studentRepo.save(newStudent);
    }

    @PatchMapping
    public void patchStudents(){

    }

    @PutMapping
    public void putStudents(){}

    @DeleteMapping
    public void deleteStudents(){}
}
