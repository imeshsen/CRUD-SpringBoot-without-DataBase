package com.example.demo.rest_client_Service;

import com.example.demo.exception_handling.AppResponse;
import com.example.demo.model.EmployeeModel;
import com.example.demo.repository.IEmployeeRepository;
import com.example.demo.rest_client_controller.ClassAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class ClientService implements IClientService {

    private RestTemplate restTemplate = new RestTemplate();


    public ResponseEntity<Object> getAll() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Object> entity = new HttpEntity<>(headers);
        ResponseEntity<Object> result = restTemplate.exchange(ClassAPI.GET_ALL_EMPLOYEES_API, HttpMethod.GET, entity, Object.class);
        AppResponse response = new AppResponse(HttpStatus.OK.value(), " RECORDS FETCHING SUCCESSFULLY... ",result);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    public ResponseEntity<Object> getById(EmployeeModel employeeModel) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Object> entity = new HttpEntity<>(headers);
        ResponseEntity<Object> result = restTemplate.exchange(ClassAPI.GET_EMPLOYEE_BY_ID, HttpMethod.GET, entity, Object.class);
        AppResponse response = new AppResponse(HttpStatus.OK.value(), "Employee Details..",result);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    public ResponseEntity<Object> addEmployee(EmployeeModel employeeModel) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<EmployeeModel> entity = new HttpEntity<>(employeeModel, headers);
        ResponseEntity<Object> result=restTemplate.exchange(ClassAPI.NEW_EMPLOYEE, HttpMethod.POST, entity, Object.class);
        AppResponse response = new AppResponse(HttpStatus.OK.value(), "Employee Added Successfully..", employeeModel);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    public ResponseEntity<Object> updateEmployee(EmployeeModel employeeModel) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<EmployeeModel> entity = new HttpEntity<>(employeeModel, headers);
        ResponseEntity<Object> result=restTemplate.exchange(ClassAPI.UPDATE_EMPLOYEE, HttpMethod.PUT, entity, Object.class);
        AppResponse response = new AppResponse(HttpStatus.OK.value(), "Employee Updated Successfully..", employeeModel);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    public ResponseEntity<Object> deleteById(EmployeeModel employeeModel) {

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Object> entity = new HttpEntity<>(headers);
        ResponseEntity<Object> result = restTemplate.exchange(ClassAPI.DELETE_EMPLOYEE, HttpMethod.DELETE, entity, Object.class);
        AppResponse response = new AppResponse(HttpStatus.OK.value(), "Employee Deleted..",result);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }
}
