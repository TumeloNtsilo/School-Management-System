package com.schoolmanagement.service;

import com.schoolmanagement.model.Admin;
import com.schoolmanagement.repository.AdminRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    private final AdminRepository adminRepo;

    public AdminService(AdminRepository adminRepo){
        this.adminRepo = adminRepo;
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
}
