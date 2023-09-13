package com.example.EmployeeManagement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employee",uniqueConstraints = {
        @UniqueConstraint(columnNames = {"emp_email"})
})
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id",nullable = false)
    private Integer empId;

    @Column(name = "first_name",nullable = false)
    private String firstName;

    @Column(name = "last_name",nullable = false)
    private String lastName;

    @Column(name = "gender",nullable = false)
    private String gender;

    @Column(name = "age")
    private Integer age;

    @Column(name = "contact_address")
    private String contactAddress;

    @Column(name = "emp_email",nullable = false)
    private String empEmail;

    @Column(name = "emp_pass",nullable = false)
    private String empPass;

}
