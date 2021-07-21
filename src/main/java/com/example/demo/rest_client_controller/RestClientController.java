package com.example.demo.rest_client_controller;

import com.example.demo.model.EmployeeModel;
import com.example.demo.rest_client_Service.ClientService;
import com.example.demo.rest_client_Service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/myApp")
public class RestClientController {

    @Autowired
    IClientService iClientService;

    @GetMapping("/getAll")
    public ResponseEntity<Object> getAllEmployees() {
        ResponseEntity<Object> responseEntity = iClientService.getAll();
        return responseEntity;

    }

    @GetMapping("/get/3")
    private ResponseEntity<Object> getEmployeeById(EmployeeModel employeeModel) {
        ResponseEntity<Object> responseEntity = iClientService.getById(employeeModel);
        return responseEntity;
    }

    @PostMapping("/new")
    public ResponseEntity<Object> addNewEmployee(@RequestBody EmployeeModel employeeModel) {
        ResponseEntity<Object> responseEntity = iClientService.addEmployee(employeeModel);
        return responseEntity;

    }

    @PutMapping("/update")
    public ResponseEntity<Object> updateEmployee(@RequestBody EmployeeModel employeeModel) {
        ResponseEntity<Object> responseEntity = iClientService.updateEmployee(employeeModel);
        return responseEntity;

    }

    @DeleteMapping("/delete/2")
    public ResponseEntity<Object> deleteEmployeeById(EmployeeModel employeeModel) {
        ResponseEntity<Object> responseEntity = iClientService.deleteById(employeeModel);
        return responseEntity;
    }
}
