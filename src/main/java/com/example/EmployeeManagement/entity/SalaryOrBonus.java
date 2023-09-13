package com.example.EmployeeManagement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "salary")
public class SalaryOrBonus {
    @Id
    @Column(name = "salary_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer salaryId;

    @Column(name = "amount")
    private Double amount;

    @Column(name = "annual")
    private Double annual;

    @Column(name = "bonus")
    private Double bonus;
    @OneToOne
    @JoinColumn(name = "job_id")
    private JobDepartment jobDepartment;
}
