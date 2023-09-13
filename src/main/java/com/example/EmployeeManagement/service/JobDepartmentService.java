package com.example.EmployeeManagement.service;

import com.example.EmployeeManagement.payload.JobDepartmentDto;

import java.util.List;

public interface JobDepartmentService {
    public JobDepartmentDto saveJob(JobDepartmentDto jobDepartmentDto);

    public List<JobDepartmentDto> getAllJob();

    public JobDepartmentDto getOneJob(int jobId);

    public JobDepartmentDto update(int jobId,JobDepartmentDto jobDepartmentDto);

    public void deleteJob(int jobId);
}
