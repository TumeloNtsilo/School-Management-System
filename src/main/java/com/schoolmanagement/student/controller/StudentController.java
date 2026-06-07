package com.schoolmanagement.student.controller;

import com.schoolmanagement.student.service.StudentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/com/schoolmanagement/student")
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
