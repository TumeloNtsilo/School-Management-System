package com.schoolmanagement.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentController {

    @GetMapping
    public String getStudents(){
        return "List of students";
    }

    @PostMapping
    public void postStudents(){
        System.out.println("Modify later");
    }

    @PatchMapping
    public void patchStudents(){

    }

    @PutMapping
    public void putStudents(){}

    @DeleteMapping
    public void deleteStudents(){}
}
