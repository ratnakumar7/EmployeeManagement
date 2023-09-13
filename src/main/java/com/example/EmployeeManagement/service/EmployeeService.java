package com.example.EmployeeManagement.service;

import com.example.EmployeeManagement.payload.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    public EmployeeDto insertEmpData(EmployeeDto employeeDto);

    public List<EmployeeDto> getAllDetails();

    public EmployeeDto getOne(int empId);

    public EmployeeDto update(int empId,EmployeeDto employeeDto);

    public void deleteEmpData(int empId);

    public List<EmployeeDto> findWithName(String name);

}
