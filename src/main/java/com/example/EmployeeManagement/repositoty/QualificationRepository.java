package com.example.EmployeeManagement.repositoty;

import com.example.EmployeeManagement.entity.Qualification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QualificationRepository extends JpaRepository<Qualification,Integer> {
}
