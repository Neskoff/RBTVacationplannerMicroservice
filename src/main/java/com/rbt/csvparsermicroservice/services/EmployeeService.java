package com.rbt.csvparsermicroservice.services;

import com.rbt.csvparsermicroservice.domain.models.Employee;
import com.rbt.csvparsermicroservice.domain.repositories.IEmployeeRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class EmployeeService implements IEmployeeService {
    @Resource
    private IEmployeeRepository iEmployeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return StreamSupport.stream(iEmployeeRepository.findAll().spliterator(), false).
                collect(Collectors.toList());
    }

}
