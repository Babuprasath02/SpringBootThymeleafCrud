package com.kgisl.springbootthymeleafcrud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kgisl.springbootthymeleafcrud.model.Employee;
import com.kgisl.springbootthymeleafcrud.repository.EmployeeRepository;
@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    public EmployeeRepository empRepo;

    @Override
    public List<Employee> getEmployee() {
     return empRepo.findAll();
    }

    @Override
    public Employee getEmployeeById(int id) {
        Optional<Employee> opt = empRepo.findById(id);
        Employee emp = null;
        if(opt.isPresent()){
            emp=opt.get();
        }else{
            throw new RuntimeException(" Employee not found for id :: " + id);
        }
       return emp;
    }

    @Override
    public void createEmployee(Employee emp) {
        this.empRepo.save(emp);
    }

    @Override
    public void deleteEmployee(int id) {
       this.empRepo.deleteById(id);
    }

  
    
}
