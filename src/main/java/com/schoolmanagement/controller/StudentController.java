package com.schoolmanagement.controller;

import com.schoolmanagement.model.Student;
import com.schoolmanagement.repository.StudentRepository;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PutMapping("/{id}")
    public Student replaceStudent(@RequestBody @Valid Student newStudent, @PathVariable Long id){
        Student student = studentRepo.findById(id)
                .orElseThrow();

        student.setFullName(newStudent.getFullName());
        student.setIdNumber(newStudent.getIdNumber());
        student.setGrade(newStudent.getGrade());

        return studentRepo.save(student);

    }

    @DeleteMapping
    public void deleteStudents(){}
}
