package com.assignment2.rest.employee.restemployeeservice.employee;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EmployeeNotFundException extends RuntimeException {
    public EmployeeNotFundException(String s) {
        super(s);
    }
}
