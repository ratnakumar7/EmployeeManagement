package com.example.EmployeeManagement.payload;

import com.example.EmployeeManagement.entity.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QualificationDto {
     private Integer qualificationId;
     private Employee employeeId;
     private String position;
     private String requirements;
     private String dateIn;
}
