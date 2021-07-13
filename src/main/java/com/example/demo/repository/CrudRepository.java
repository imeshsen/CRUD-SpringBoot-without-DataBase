package com.example.demo.repository;

import com.example.demo.model.CrudModel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CrudRepository {
    private Map<Integer, CrudModel> employees = new HashMap<>();
    {
        CrudModel employee1 = new CrudModel(1, "Prashant", "9956823659", 50000);
        CrudModel employee2 = new CrudModel(2, "Billa", "9000256893", 25000);
        employees.put(1, employee1);
        employees.put(2, employee2);
    }

    public List<CrudModel> getAllEmployees() {
        return new ArrayList<>(employees.values());
    }

    public CrudModel getEmployeeDetails(int empId) {
        return employees.get(empId);
    }

    public CrudModel addEmployee(int empId, CrudModel employee) {
        employee.setEmpId(empId);
        employees.put(empId, employee);
        return employee;
    }

    public CrudModel updateEmployee(int empId, CrudModel employee) {
        employee.setEmpId(empId);
        employees.put(empId, employee);
        return employee;
    }

    public CrudModel deleteEmployeeDetails(int empId) {
        return employees.remove(empId);
    }
}
