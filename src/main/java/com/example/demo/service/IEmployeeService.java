package com.example.demo.service;

import com.example.demo.model.EmployeeModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IEmployeeService {

    List<EmployeeModel> getEmployees();

    EmployeeModel getEmployeeDetails(Integer empId);

    EmployeeModel addEmployeeDetails(EmployeeModel employee);

    EmployeeModel updateEmployeeDetails(EmployeeModel employee);

    EmployeeModel deleteEmployee(Integer empId);

}
