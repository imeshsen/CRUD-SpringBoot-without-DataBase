package com.example.demo.service;

import com.example.demo.model.EmployeeModel;
import com.example.demo.repository.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    IEmployeeRepository iEmployeeRepository;

    @Override
    public List<EmployeeModel> getEmployees() {
        return iEmployeeRepository.getAllEmployees();
    }

    @Override
    public EmployeeModel getEmployeeDetails(Integer empId) {
        return iEmployeeRepository.getEmployeeDetails(empId);
    }

    @Override
    public EmployeeModel addEmployeeDetails(EmployeeModel employee) {
        return iEmployeeRepository.addEmployee(employee);
    }

    @Override
    public EmployeeModel updateEmployeeDetails(EmployeeModel employee) {
        return iEmployeeRepository.updateEmployee(employee);
    }

    @Override
    public EmployeeModel deleteEmployee(Integer empId) {
        return iEmployeeRepository.deleteEmployeeDetails(empId);
    }
}
