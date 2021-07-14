package com.example.demo.service;

import com.example.demo.model.EmployeeModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IEmployeeService {

    List<EmployeeModel> getEmployees();

    EmployeeModel getEmployeeDetails(Integer empId);

    EmployeeModel addEmployeeDetails(Integer employeeId, EmployeeModel employee);

    EmployeeModel updateEmployeeDetails(Integer employeeId, EmployeeModel employee);

    EmployeeModel deleteEmployee(Integer empId);

}
