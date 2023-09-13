package com.example.EmployeeManagement.serviceImpl;

import com.example.EmployeeManagement.entity.JobDepartment;
import com.example.EmployeeManagement.payload.JobDepartmentDto;
import com.example.EmployeeManagement.repositoty.JobDepartmentRepository;
import com.example.EmployeeManagement.service.JobDepartmentService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class JobDepartmentServiceImpl implements JobDepartmentService {
    @Autowired
    private JobDepartmentRepository jobDepartmentRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public JobDepartmentDto saveJob(JobDepartmentDto jobDepartmentDto) {
        JobDepartment jobDepartment = modelMapper.map(jobDepartmentDto, JobDepartment.class);
         jobDepartmentRepository.save(jobDepartment);
        return modelMapper.map(jobDepartment,JobDepartmentDto.class);
    }

    @Override
    public List<JobDepartmentDto> getAllJob() {
        List<JobDepartment> jd = jobDepartmentRepository.findAll();
        return jd.stream()
                .map(x->modelMapper.map(x,JobDepartmentDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public JobDepartmentDto getOneJob(int jobId) {
        jobDepartmentRepository.findById(jobId).orElseThrow(()->new RuntimeException(""));
        return null;
    }

    @Override
    public JobDepartmentDto update(int jobId, JobDepartmentDto jobDepartmentDto) {
        Optional<JobDepartment> jobDepartment = jobDepartmentRepository.findById(jobId);
        if (jobDepartment.isPresent()){
            jobDepartment.get().setJobDept(jobDepartmentDto.getJobDept());
            jobDepartment.get().setName(jobDepartmentDto.getName());
            jobDepartment.get().setDescription(jobDepartmentDto.getDescription());
            jobDepartment.get().setSalaryRange(jobDepartmentDto.getSalaryRange());
            return modelMapper.map(jobDepartment,JobDepartmentDto.class);
        }
        else {
            throw new RuntimeException("Jod Id is not present");
        }

    }

    @Override
    public void deleteJob(int jobId) {
        jobDepartmentRepository.deleteById(jobId);
    }
}
