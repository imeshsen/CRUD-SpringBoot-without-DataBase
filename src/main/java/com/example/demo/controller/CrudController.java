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

    @PostMapping("/newEmployee/{employeeId}")
    public EmployeeModel addEmployeeDetails(@PathVariable Integer employeeId, @RequestBody EmployeeModel employee) {
        return iEmployeeService.addEmployeeDetails(employeeId, employee);
    }

    @PutMapping("/updateEmployee/{employeeId}")
    public EmployeeModel updateEmployeeDetails(@PathVariable Integer employeeId, @RequestBody EmployeeModel employee) {
        return iEmployeeService.updateEmployeeDetails(employeeId, employee);
    }

    @DeleteMapping("/deleteEmployee/{empId}")
    public EmployeeModel deleteEmployee(@PathVariable Integer empId) {
        return iEmployeeService.deleteEmployee(empId);
    }
}
