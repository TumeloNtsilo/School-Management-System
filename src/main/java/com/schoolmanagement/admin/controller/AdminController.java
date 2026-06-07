package com.schoolmanagement.admin.controller;

import com.schoolmanagement.admin.model.Admin;
import com.schoolmanagement.student.model.Student;
import com.schoolmanagement.admin.service.AdminService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    private final AdminService adminService;

    public AdminController(AdminService adminService){
        this.adminService = adminService;
    }

    @GetMapping("/{id}")
    public Admin admin(@PathVariable Long id){
        return adminService.findAdminById(id);
    }

    @GetMapping("/all")
    public List<Admin> allAdmins(){
        return adminService.allAdmins();
    }

    @PostMapping
    public Admin addAmin(@RequestBody @Valid Admin admin){
        return adminService.createAdmin(admin);

    }

    @PutMapping("/{id}")
    public Admin replaceAdminDetails(@RequestBody @Valid Admin newAdmin, @PathVariable Long id){
        return adminService.updateAdmin(newAdmin, id);
    }

    @DeleteMapping("/{id}")
    public Admin removeAdmin(@PathVariable Long id){
        return adminService.removeAdmin(id);
    }

    @GetMapping("/students")
    public List<Student> getStudents(){
        return adminService.getAllStudents();
    }

    @PostMapping("/students")
    public void addNewStudent(@RequestBody @Valid Student newStudent){
        adminService.addNewStudent(newStudent);
    }

    @PatchMapping("/students")
    public void patchStudents(){

    }

    @PutMapping("/students/{id}")
    public Student replaceStudent(@RequestBody @Valid Student newStudent, @PathVariable Long id){
        return adminService.replaceStudent(newStudent, id);
    }

    @DeleteMapping("/students/{id}")
    public Student deleteStudents(@PathVariable Long id){
        return adminService.removeStudent(id);
    }

}
