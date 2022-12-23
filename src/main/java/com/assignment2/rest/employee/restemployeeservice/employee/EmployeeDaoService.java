package com.assignment2.rest.employee.restemployeeservice.employee;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class EmployeeDaoService {
    private static List<Employee> employees = new ArrayList<>();
    private static int employeeCount = 104;

    static {
        employees.add(new Employee(101, "Marcus", "Rashford", 100000));
        employees.add(new Employee(102, "Jadon", "Sancho", 90000));
        employees.add(new Employee(103, "Anthony", "Martial", 60000));
        employees.add(new Employee(104, "Bruno", "Fernandes", 90000));
    }

    public List<Employee> findAll() {
        return employees;
    }

    public Employee saveEmployee(Employee employee) {
        if (employee.getId() == null) {
            employee.setId(++employeeCount);
        }
        employees.add(employee);
        return employee;
    }

    public Employee findOne(int id) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }

    public Employee update(int id, Employee reqemployee) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                employee.setSalary(reqemployee.getSalary());
                System.out.println(employee);
                return employee;
            }
        }
        return null;
    }

    public Employee delete(int id) {
        Iterator<Employee> iterator = employees.iterator();
        while (iterator.hasNext()) {
            Employee employee = iterator.next();
            if (employee.getId() == id) {
                iterator.remove();
                return employee;
            }

        }

        return null;
    }


}


