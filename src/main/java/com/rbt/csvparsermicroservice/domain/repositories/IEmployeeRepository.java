package com.rbt.csvparsermicroservice.domain.repositories;

import com.rbt.csvparsermicroservice.domain.models.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmployeeRepository extends CrudRepository<Employee, String> {

}
