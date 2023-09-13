package com.example.EmployeeManagement.controller;

import com.example.EmployeeManagement.entity.Employee;
import com.example.EmployeeManagement.payload.EmployeeDto;
import com.example.EmployeeManagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/emp")
public class EmployeeController {
    private EmployeeService employeeService;
    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @PostMapping("/insert")
    public EmployeeDto insertDetails(@RequestBody EmployeeDto employeeDto){
       return employeeService.insertEmpData(employeeDto);
    }
    @GetMapping("/fetch-all")
    public List<EmployeeDto> getAllDetails(){
        return employeeService.getAllDetails();
    }
    @GetMapping("/{empId}")
    public EmployeeDto getOneData(@PathVariable("empId") int empId){
        return employeeService.getOne(empId);
    }
    @PutMapping("/{empId}/update")
    public EmployeeDto findOne(@PathVariable("empId") int empId,@RequestBody EmployeeDto employeeDto){
        return employeeService.update(empId,employeeDto);
    }
    @GetMapping("/name/{name}")
    public List<EmployeeDto> getByName(@PathVariable("name") String name){
        return employeeService.findWithName(name);
    }
}
