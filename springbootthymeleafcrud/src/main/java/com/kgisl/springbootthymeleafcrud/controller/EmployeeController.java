package com.kgisl.springbootthymeleafcrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.kgisl.springbootthymeleafcrud.model.Employee;
import com.kgisl.springbootthymeleafcrud.service.EmployeeService;

@Controller
public class EmployeeController {
    @Autowired
    public EmployeeService empService;

    @GetMapping("/")
    public String viewForm(Model model) {
        model.addAttribute("listEmployee", empService.getEmployee());
        return "index";
    }

    @GetMapping("/showNewForm")
    public String createEmployee(Model model) {
        Employee emp = new Employee();
        model.addAttribute("employee", emp);
        return "new_employee";
    }

    @PostMapping("/saveEmployee")
    public String saveEmp(@ModelAttribute("employee") Employee emp) {
        empService.createEmployee(emp);
        return "redirect:/";
    }
    @GetMapping("/showFormForUpdate/{id}")
    public String updateEmp(@PathVariable("id") int id, Model model){
        Employee emp = empService.getEmployeeById(id);
        model.addAttribute("employee", emp);

        return "update_employee";
        
    }
    @GetMapping("deleteEmployee/{id}")
    public String deleteEmp(@PathVariable("id") int id){
        empService.deleteEmployee(id);
        return "redirect:/";

    }

}
