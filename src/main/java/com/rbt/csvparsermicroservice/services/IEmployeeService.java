package com.rbt.csvparsermicroservice.services;

import com.rbt.csvparsermicroservice.domain.models.Employee;

import java.util.List;

public interface IEmployeeService {
    List<Employee> getAllEmployees();
}
