package com.example.demo.rest_client;

import com.example.demo.exception_handling.AppResponse;
import com.example.demo.model.EmployeeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/myApp")
public class RestClient {
    private static final String GET_ALL_EMPLOYEES_API = "http://localhost:8080/employees";
    private static final String GET_EMPLOYEE_BY_ID = "http://localhost:8080/getEmployee/3";
    private static final String NEW_EMPLOYEE = "http://localhost:8080/newEmployee";
    private static final String UPDATE_EMPLOYEE = "http://localhost:8080/updateEmployee";
    private static final String DELETE_EMPLOYEE="http://localhost:8080/deleteEmployee/2";

    private RestTemplate restTemplate = new RestTemplate();


    @GetMapping("/getAll")
    private ResponseEntity<Object> getAllEmployees() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Object> entity = new HttpEntity<>(headers);
        ResponseEntity<Object> result = restTemplate.exchange(GET_ALL_EMPLOYEES_API, HttpMethod.GET, entity, Object.class);
        AppResponse response = new AppResponse(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(), result);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/get/2")
    private ResponseEntity<Object> getEmployeeById() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Object> entity = new HttpEntity<>(headers);
        ResponseEntity<String> result = restTemplate.exchange(GET_EMPLOYEE_BY_ID, HttpMethod.GET, entity, String.class);
        AppResponse response = new AppResponse(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(), result);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @PostMapping("/new")
    public EmployeeModel addNewEmployee(@RequestBody EmployeeModel employeeModel) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<EmployeeModel> entity = new HttpEntity<>(employeeModel, headers);
        EmployeeModel emp = restTemplate.exchange(NEW_EMPLOYEE, HttpMethod.POST, entity, EmployeeModel.class).getBody();
        return emp;
    }

    @PutMapping("/update")
    public EmployeeModel updateEmployee(@RequestBody EmployeeModel employeeModel) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<EmployeeModel> entity = new HttpEntity<>(employeeModel, headers);
        EmployeeModel emp = restTemplate.exchange(UPDATE_EMPLOYEE, HttpMethod.PUT, entity, EmployeeModel.class).getBody();
        return emp;
    }

    @DeleteMapping("/delete/2")
    public ResponseEntity<Object> deleteEmployeeById(){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Object> entity = new HttpEntity<>(headers);
        ResponseEntity<String> result = restTemplate.exchange(DELETE_EMPLOYEE, HttpMethod.DELETE, entity, String.class);
        AppResponse response = new AppResponse(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(), result);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

}
