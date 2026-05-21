package com.schoolmanagement.controller;

import com.schoolmanagement.model.Student;
import com.schoolmanagement.repository.StudentRepository;
import com.schoolmanagement.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents(){
        return studentService.getAllStudents();
    }

    @PostMapping
    public void addNewStudent(@RequestBody @Valid Student newStudent){
        studentService.addNewStudent(newStudent);
    }

    @PatchMapping
    public void patchStudents(){

    }

    @PutMapping("/{id}")
    public Student replaceStudent(@RequestBody @Valid Student newStudent, @PathVariable Long id){
        return studentService.replaceStudent(newStudent, id);
    }

    @DeleteMapping
    public void deleteStudents(){}
}
