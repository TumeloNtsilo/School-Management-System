package com.schoolmanagement.controller;

import com.schoolmanagement.model.Student;
import com.schoolmanagement.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping
    public String getStudent(){
        return studentService.getStudentDetails();
    }


}
