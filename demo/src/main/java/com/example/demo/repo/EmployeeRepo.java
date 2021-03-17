package com.example.demo.repo;

import com.example.demo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {


    void deleteById(Long id);

    Optional<Employee> findEmployeeById(Long id);
}
