package com.example.EmployeeManagement.repositoty;

import com.example.EmployeeManagement.entity.SalaryOrBonus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalaryOrBonusRepository extends JpaRepository<SalaryOrBonus,Integer> {
}
