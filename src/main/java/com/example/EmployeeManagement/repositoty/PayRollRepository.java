package com.example.EmployeeManagement.repositoty;

import com.example.EmployeeManagement.entity.PayRoll;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PayRollRepository extends JpaRepository<PayRoll,Integer> {
}
