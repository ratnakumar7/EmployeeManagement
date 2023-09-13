package com.example.EmployeeManagement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "qualification")
public class Qualification {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name = "qualification_id")
     private Integer qualificationId;
     @OneToOne
     @JoinColumn(name = "empId")
     private Employee employeeId;

     @Column(name = "position")
     private String position;

     @Column(name = "requirement")
     private String requirements;

     @Column(name = "date_in")
     private String dateIn;
}
