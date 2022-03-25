package rbt.excelimportv2.repository;

import org.springframework.data.repository.CrudRepository;
import rbt.excelimportv2.entity.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    Employee findByUsername(String username);
}
