package com.example.restApi.controller;

import com.example.restApi.model.Employee;
import com.example.restApi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmplyeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/all")
    public List<Employee> get (){
        return employeeService.getAll();
    }

    @PostMapping("/add")
    public Employee add (@RequestBody Employee employee){
        return employeeService.addEmployee(employee);
    }

    @PutMapping("/{id}")
    public Employee update (@PathVariable Long id, @RequestBody Employee employee){
        return employeeService.updateEmployee(id,employee);
    }

    @DeleteMapping("/{id}")
    public void  delete (@PathVariable Long id){
        employeeService.deleteEmployee(id);
    }

}
