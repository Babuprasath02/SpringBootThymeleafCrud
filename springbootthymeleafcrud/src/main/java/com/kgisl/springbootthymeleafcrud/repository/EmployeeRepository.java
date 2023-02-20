package com.kgisl.springbootthymeleafcrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kgisl.springbootthymeleafcrud.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
    
}
