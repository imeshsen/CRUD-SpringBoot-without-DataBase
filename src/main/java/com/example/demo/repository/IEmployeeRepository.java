package com.example.demo.repository;

import com.example.demo.model.EmployeeModel;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEmployeeRepository {

    List<EmployeeModel> getAllEmployees();

    EmployeeModel getEmployeeDetails(Integer empId);

    EmployeeModel addEmployee(Integer employeeId, EmployeeModel employee);

    EmployeeModel updateEmployee(Integer empId, EmployeeModel employee);

    EmployeeModel deleteEmployeeDetails(Integer empId);

}
