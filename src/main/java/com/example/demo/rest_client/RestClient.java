package com.example.demo.rest_client;

import com.example.demo.exception_handling.AppResponse;
import com.example.demo.model.EmployeeModel;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/myApp")
public class RestClient {
    private static final String GET_ALL_EMPLOYEES_API = "http://localhost:8080/employees";
    private static final String GET_EMPLOYEE_BY_ID="http://localhost:8080/getEmployee/2";
    static RestTemplate restTemplate = new RestTemplate();

    public static void main(String[] args) {
        getAllEmployees();
        getEmployeeById();
    }
    @GetMapping("/getAll")
    private static ResponseEntity<Object> getAllEmployees(){
        HttpHeaders headers=new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Object> entity=new HttpEntity<>("parameters",headers);
        ResponseEntity<Object> result=restTemplate.exchange(GET_ALL_EMPLOYEES_API, HttpMethod.GET,entity,Object.class);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @GetMapping("/get/2")
    private static ResponseEntity<Object> getEmployeeById(){
        HttpHeaders headers=new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Object> entity=new HttpEntity<>("parameters",headers);
        ResponseEntity<Object> result=restTemplate.exchange(GET_EMPLOYEE_BY_ID, HttpMethod.GET,entity,Object.class);
        AppResponse response = new AppResponse(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(),result);
        return new ResponseEntity<>(response,HttpStatus.OK);

    }
}
