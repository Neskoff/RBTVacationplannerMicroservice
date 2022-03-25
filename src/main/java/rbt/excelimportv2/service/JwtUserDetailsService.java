package rbt.excelimportv2.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import rbt.excelimportv2.entity.Employee;
import rbt.excelimportv2.repository.EmployeeRepository;

import javax.annotation.Resource;
import java.util.ArrayList;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Resource
    private EmployeeRepository employeeRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Employee employee = employeeRepository.findByUsername(username);
        if (employee != null) {
            return new Employee(employee.getId(), employee.getUsername(), employee.getPassword(),
                    true);
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }
}