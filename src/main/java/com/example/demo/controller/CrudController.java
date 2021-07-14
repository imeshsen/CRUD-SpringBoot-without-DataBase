package com.example.demo.controller;

import com.example.demo.model.EmployeeModel;
import com.example.demo.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CrudController {

    @Autowired
    IEmployeeService iEmployeeService;

    @GetMapping("/employees")
    public List<EmployeeModel> getEmployees() {
        return iEmployeeService.getEmployees();
    }

    @GetMapping("/getEmployee/{empId}")
    public EmployeeModel getEmployeeDetails(@PathVariable Integer empId) {
        return iEmployeeService.getEmployeeDetails(empId);
    }

    @PostMapping("/newEmployee")
    public EmployeeModel addEmployeeDetails(@RequestBody EmployeeModel employee) {
        return iEmployeeService.addEmployeeDetails(employee);
    }

    @PutMapping("/updateEmployee")
    public EmployeeModel updateEmployeeDetails(@RequestBody EmployeeModel employee) {
        return iEmployeeService.updateEmployeeDetails(employee);
    }

    @DeleteMapping("/deleteEmployee/{empId}")
    public EmployeeModel deleteEmployee(@PathVariable Integer empId) {
        return iEmployeeService.deleteEmployee(empId);
    }
}
