package com.schoolmanagement.service;

import com.schoolmanagement.model.Student;
import com.schoolmanagement.repository.StudentRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepo;

    public StudentService(StudentRepository studentRepo){
        this.studentRepo = studentRepo;
    }

    public List<Student> getAllStudents(){
        return studentRepo.findAll();
    }

    public void addNewStudent(Student newStudent){
        studentRepo.save(newStudent);
    }

    public Student replaceStudent(Student newStudent, Long id){
        Student oldStudent = studentRepo.findById(id)
                .orElseThrow();

        oldStudent.setFullName(newStudent.getFullName());
        oldStudent.setIdNumber(newStudent.getIdNumber());
        oldStudent.setGrade(newStudent.getGrade());

        return studentRepo.save(oldStudent);

    }

    public Student removeStudent(Long id){
        Student student = studentRepo.findById(id)
                .orElseThrow();
        studentRepo.delete(student);

        return student;
    }


}
