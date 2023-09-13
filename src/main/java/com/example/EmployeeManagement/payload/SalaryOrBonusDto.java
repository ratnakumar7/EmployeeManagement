package com.example.EmployeeManagement.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SalaryOrBonusDto {
    private Integer salaryId;
    private Double amount;
    private Double annual;
    private Double bonus;
}
