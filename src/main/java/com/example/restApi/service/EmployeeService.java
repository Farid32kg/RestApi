package com.example.restApi.service;

import com.example.restApi.model.Employee;
import com.example.restApi.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAll(){
      return   employeeRepository.findAll();
    }

    public Employee addEmployee (Employee employee){
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee (Long id, Employee employee1){
        Employee employee = employeeRepository.findById(id).orElseThrow(()->new RuntimeException("ID " + id+ "Not Found"));
        employee.setName(employee1.getName());
        employee.setSurname(employee1.getSurname());
        employee.setAge(employee1.getAge());
        return employeeRepository.save(employee);
    }

    public void deleteEmployee (Long id){
        employeeRepository.deleteById(id);
    }

}
