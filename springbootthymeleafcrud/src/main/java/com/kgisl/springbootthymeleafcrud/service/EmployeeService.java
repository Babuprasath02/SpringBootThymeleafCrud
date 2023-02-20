package com.kgisl.springbootthymeleafcrud.service;

import java.util.List;

import com.kgisl.springbootthymeleafcrud.model.Employee;

public interface EmployeeService {
    public List<Employee> getEmployee();
    public Employee getEmployeeById(int id);
    public void createEmployee(Employee emp);
    public void deleteEmployee(int id);

    
}
