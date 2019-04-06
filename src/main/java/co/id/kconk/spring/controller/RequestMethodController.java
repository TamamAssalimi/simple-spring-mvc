package co.id.kconk.spring.controller;

import co.id.kconk.spring.exception.InvalidRequestException;
import co.id.kconk.spring.domain.Employee;
import co.id.kconk.spring.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/api")
public class RequestMethodController {

    @Autowired
    EmployeeService service;

    @RequestMapping(value = "/employees", produces = "application/json", method={RequestMethod.GET,RequestMethod.POST})
    public List<Employee> findEmployees()
            throws InvalidRequestException {
        return service.getEmployeeList();
    }
}
