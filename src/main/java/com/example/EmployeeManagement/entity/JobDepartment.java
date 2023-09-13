package com.example.EmployeeManagement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class JobDepartment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "job_id")
    private Integer jobId;

    @Column(name = "job_dept")
    private String jobDept;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;
    @Column(name = "salary_range")
    private Double salaryRange;

}
