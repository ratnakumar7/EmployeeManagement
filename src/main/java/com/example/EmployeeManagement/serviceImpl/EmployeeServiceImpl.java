package com.example.EmployeeManagement.serviceImpl;

import com.example.EmployeeManagement.entity.Employee;
import com.example.EmployeeManagement.exception.EmployeeNotFound;
import com.example.EmployeeManagement.payload.EmployeeDto;
import com.example.EmployeeManagement.repositoty.EmployeeRepository;
import com.example.EmployeeManagement.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public EmployeeDto insertEmpData(EmployeeDto employeeDto) {
        Employee employee = modelMapper.map(employeeDto, Employee.class);
        employeeRepository.save(employee);
        return modelMapper.map(employee, EmployeeDto.class);
    }

    @Override
    public List<EmployeeDto> getAllDetails() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream()
                .map(details -> modelMapper
                        .map(details, EmployeeDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto getOne(int empId) {
           Employee employee = employeeRepository.findById(empId)
                   .orElseThrow(()->new EmployeeNotFound(String.format("Employee %d is Not Found ",empId)));
           return modelMapper.map(employee,EmployeeDto.class);
    }

    @Override
    public EmployeeDto update(int empId, EmployeeDto employeeDto) {
        Employee employee = employeeRepository
                .findById(empId)
                .orElseThrow(()->new EmployeeNotFound(String.format("Employee %d is not Found",empId)));
        Employee employee1 = new Employee();
        employee1.setFirstName(employeeDto.getFirstName());
        employee1.setLastName(employeeDto.getLastName());
        employee1.setGender(employeeDto.getGender());
        employee1.setAge(employeeDto.getAge());
        employee1.setEmpEmail(employeeDto.getEmpEmail());
        employee1.setEmpPass(employeeDto.getEmpPass());
        employeeRepository.save(employee1);
        return modelMapper.map(employee1,EmployeeDto.class);
    }
    @Override
    public void deleteEmpData(int empId) {
          employeeRepository.findById(empId)
                  .orElseThrow(()->new EmployeeNotFound(String.format("Employee %d is not Found",empId)));
          employeeRepository.deleteById(empId);
    }

    @Override
    public List<EmployeeDto> findWithName(String name) {
        List<Employee> emp =  employeeRepository.findByfirstName(name);
        return emp.stream()
                .map(x->modelMapper.map(x,EmployeeDto.class))
                .collect(Collectors.toList());
    }

}
