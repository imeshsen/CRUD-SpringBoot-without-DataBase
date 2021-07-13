package com.example.demo.repository;

import com.example.demo.model.CrudModel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CrudRepository {
    static private Map<Integer, CrudModel> employees = new HashMap<>();

    {
        CrudModel employee1 = new CrudModel(1, "Prashant", "9956823659", 50000);
        CrudModel employee2 = new CrudModel(2, "Billa", "9000256893", 25000);
        employees.put(employee1.getEmpId(), employee1);
        employees.put(employee2.getEmpId(), employee2);
    }

    public List<CrudModel> getAllEmployees() {
        return new ArrayList<>(employees.values());
    }

    public CrudModel getEmployeeDetails(int empId) {
        return employees.get(empId);
    }

    public static CrudModel addEmployee(int employeeId, CrudModel employee) {
        if (!employees.containsKey(employeeId)) {
            employee.setEmpId(employeeId);
            employees.put(employee.getEmpId(), employee);
            return employee;
        }
        return null;
    }

    public CrudModel updateEmployee(int empId, CrudModel employee) {
        if (employees.containsKey(empId)) {
            employees.put(employee.getEmpId(), employee);
            return employee;
        }
        return null;
    }

    public CrudModel deleteEmployeeDetails(int empId) {
        return employees.remove(empId);
    }
}
