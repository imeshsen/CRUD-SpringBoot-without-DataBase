package com.example.demo.repository;

import com.example.demo.model.EmployeeModel;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEmployeeRepository {

    List<EmployeeModel> getAllEmployees();

    EmployeeModel getEmployeeDetails(Integer empId);

    EmployeeModel addEmployee(EmployeeModel employee);

    EmployeeModel updateEmployee(EmployeeModel employee);

    String deleteEmployeeDetails(Integer empId);

}
