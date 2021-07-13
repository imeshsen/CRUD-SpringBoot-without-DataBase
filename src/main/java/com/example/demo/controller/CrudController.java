package com.example.demo.controller;

import com.example.demo.model.CrudModel;
import com.example.demo.repository.CrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CrudController {
    @Autowired
    CrudRepository crudRepository;

    @GetMapping("/employees")
    public List<CrudModel> getEmployees() {
        return crudRepository.getAllEmployees();
    }

    @GetMapping("/getEmployee/{empId}")
    public CrudModel getEmployeeDetails(@PathVariable int empId) {
        return crudRepository.getEmployeeDetails(empId);
    }

    @PostMapping("/newEmployee/{employeeId}")
    public CrudModel addEmployeeDetails(@PathVariable Integer employeeId, @RequestBody CrudModel employee) {
        return crudRepository.addEmployee(employeeId, employee);
    }

    @PutMapping("/updateEmployee/{employeeId}")
    public CrudModel updateEmployeeDetails(@PathVariable Integer employeeId, @RequestBody CrudModel employee) {
        return crudRepository.updateEmployee(employeeId, employee);
    }

    @DeleteMapping("/deleteEmployee/{empId}")
    public CrudModel deleteEmployee(@PathVariable int empId) {
        return crudRepository.deleteEmployeeDetails(empId);
    }
}
