package com.example.demo.controller;

import com.example.demo.exception_handling.AppResponse;
import com.example.demo.model.EmployeeModel;
import com.example.demo.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    IEmployeeService iEmployeeService;

    @GetMapping("/employees")
    public ResponseEntity<Object> getEmployees() {
        List<EmployeeModel> employeeModels = iEmployeeService.getEmployees();
        if (!employeeModels.isEmpty()) {
            AppResponse response = new AppResponse(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(), employeeModels);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            AppResponse response = new AppResponse(HttpStatus.BAD_REQUEST.value(), "NO DATA FUND ", null);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getEmployee/{empId}")
    public ResponseEntity<Object> getEmployeeDetails(@PathVariable Integer empId) {
        EmployeeModel employeeModel = iEmployeeService.getEmployeeDetails(empId);
        if (employeeModel != null) {
            AppResponse response = new AppResponse(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(), employeeModel);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            AppResponse response = new AppResponse(HttpStatus.BAD_REQUEST.value(), "INVALID EMPLOYEE ID", null);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/newEmployee")
    public ResponseEntity<Object> addEmployeeDetails(@RequestBody EmployeeModel employee) {
        EmployeeModel employeeModel = iEmployeeService.addEmployeeDetails(employee);
        if (employeeModel != null) {
            AppResponse response = new AppResponse(HttpStatus.OK.value(), "RECORD INSERTED SUCCESSFULLY.. ", employeeModel);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            AppResponse response = new AppResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), "EMPLOYEE ID EXISTS, PLEASE INSERT DATA IN ANOTHER EMPLOYEE ID", null);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/updateEmployee")
    public ResponseEntity<Object> updateEmployeeDetails(@RequestBody EmployeeModel employee) {
        EmployeeModel employeeModel = iEmployeeService.updateEmployeeDetails(employee);
        if (employeeModel != null) {
            AppResponse response = new AppResponse(HttpStatus.OK.value(), " RECORD UPDATED  SUCCESSFULLY.. ", employeeModel);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            AppResponse response = new AppResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), " INVALID EMPLOYEE ID ", null);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteEmployee/{empId}")
    public ResponseEntity<Object> deleteEmployee(@PathVariable Integer empId) {
        String s = iEmployeeService.deleteEmployee(empId);
        if (s != null) {
            AppResponse response = new AppResponse(HttpStatus.OK.value(), "RECORD DELETED SUCCESSFULLY..", s
            );
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            AppResponse response = new AppResponse(HttpStatus.BAD_REQUEST.value(), "INVALID EMPLOYEE ID", null);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }
}
