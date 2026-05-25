package com.schoolmanagement.service;

import com.schoolmanagement.model.Admin;
import com.schoolmanagement.model.Student;
import com.schoolmanagement.repository.AdminRepository;
import com.schoolmanagement.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    private final AdminRepository adminRepo;
    private final StudentRepository studentRepo;

    public AdminService(AdminRepository adminRepo, StudentRepository studentRepo){
        this.adminRepo = adminRepo;
        this.studentRepo = studentRepo;
    }

    public List<Admin> allAdmins(){
        return adminRepo.findAll();
    }

    public Admin findAdminById(Long id){
        return adminRepo.findById(id).orElseThrow();
    }

    public Admin createAdmin(Admin newAdmin){
        return adminRepo.save(newAdmin);
    }

    public Admin updateAdmin(Admin updatedAdmin, Long id){

        Admin admin = adminRepo.findById(id)
                .orElseThrow();

        admin.setFullName(updatedAdmin.getFullName());
        admin.setEmail(updatedAdmin.getEmail());
        admin.setPassword(updatedAdmin.getPassword());

        return adminRepo.save(admin);
    }

    public Admin removeAdmin(Long id){

        Admin admin = adminRepo.findById(id)
                .orElseThrow();

        adminRepo.delete(admin);

        return admin;
    }

    /**
     * This is all for the Student
     */

    public List<Student> getAllStudents(){
        return studentRepo.findAll();
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
