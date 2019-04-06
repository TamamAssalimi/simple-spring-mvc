package co.id.kconk.spring.service;

import co.id.kconk.spring.domain.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {

    List<Employee> getEmployeeList();
}
