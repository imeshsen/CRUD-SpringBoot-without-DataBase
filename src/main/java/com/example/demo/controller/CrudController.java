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
    public List<CrudModel> getEmployees(){
        return crudRepository.getAllEmployees();
    }
    @GetMapping("/getEmployee/{empId}")
    public CrudModel getEmployeeDetails(@PathVariable int empId){
        return crudRepository.getEmployeeDetails(empId);
    }
    @PostMapping("/newEmployee/{empId}")
    public CrudModel addEmployeeDetails(@PathVariable int empId,@RequestBody CrudModel employee){
        return crudRepository.addEmployee(empId,employee);
    }
    @PutMapping("/updateEmployee/{EmpId}")
    public CrudModel updateEmployeeDetails(@PathVariable int empId,@RequestBody CrudModel employee){
        return crudRepository.updateEmployee(empId,employee);
    }
    @DeleteMapping("/deleteEmployee/{empId}")
    public CrudModel deleteEmployee(@PathVariable int empId){
        return crudRepository.deleteEmployeeDetails(empId);
    }
}
