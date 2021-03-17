package com.example.demo.service;


import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.Employee;
import com.example.demo.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {
    private final EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public Employee addEmployee(Employee employee) {
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return this.employeeRepo.save(employee);
    }

    public List<Employee> findAllEmployees() {
        return  this.employeeRepo.findAll();
    }

    public Employee updateEmployee(Employee employee) {
        return this.employeeRepo.save(employee);
    }

    public void deleteEmployee(Long id){
        this.employeeRepo.deleteById(id);
    }

    public Employee findEmployeeById(Long id){
        return  this.employeeRepo.findEmployeeById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id "+id+" was not found"));
    }
}
