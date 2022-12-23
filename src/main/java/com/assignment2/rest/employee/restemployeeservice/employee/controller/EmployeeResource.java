package com.assignment2.rest.employee.restemployeeservice.employee.controller;

import com.assignment2.rest.employee.restemployeeservice.employee.Employee;
import com.assignment2.rest.employee.restemployeeservice.employee.EmployeeDaoService;
import com.assignment2.rest.employee.restemployeeservice.employee.EmployeeNotFundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeResource {
    @Autowired
    private EmployeeDaoService service;

    @GetMapping("/employee/findAll")
    public ResponseEntity<List<Employee>> retrieveEmployees() {
        return new ResponseEntity<List<Employee>>(service.findAll(), HttpStatus.OK);

    }

    @PostMapping("/employee")
    public ResponseEntity<Employee> AddEmployee(@RequestBody Employee employee) {
        return new ResponseEntity<Employee>(service.saveEmployee(employee), HttpStatus.ACCEPTED);

    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> findEmployee(@PathVariable int id) {
        Employee employee = service.findOne(id);
        if (employee == null) {
            throw new EmployeeNotFundException("id-" + id);

        }
        return new ResponseEntity<Employee>(employee, HttpStatus.ACCEPTED);
    }

    @PutMapping("employee/{id}")
    public ResponseEntity<Employee> updateSalary(@PathVariable int id, @RequestBody Employee reqEmployee) {
        Employee employee = service.update(id, reqEmployee);
        if (employee == null) {
            throw new EmployeeNotFundException("id-" + id);

        }
        return new ResponseEntity<Employee>(employee, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/employee/{id}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable int id) {
        Employee employee = service.delete(id);
        if (employee == null) {
            throw new EmployeeNotFundException("id-" + id);

        }
        return new ResponseEntity<Employee>(employee, HttpStatus.ACCEPTED);
    }
}
