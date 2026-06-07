package com.schoolmanagement.admin.repository;
import com.schoolmanagement.admin.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
}
