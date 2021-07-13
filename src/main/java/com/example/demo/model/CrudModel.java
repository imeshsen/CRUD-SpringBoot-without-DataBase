package com.example.demo.model;

public class CrudModel {
    private int empId;
    private String empName;
    private String empMobile;
    private double empSal;

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpMobile() {
        return empMobile;
    }

    public void setEmpMobile(String empMobile) {
        this.empMobile = empMobile;
    }

    public double getEmpSal() {
        return empSal;
    }

    public void setEmpSal(double empSal) {
        this.empSal = empSal;
    }

    public CrudModel(int empId, String empName, String empMobile, double empSal) {
        this.empId = empId;
        this.empName = empName;
        this.empMobile = empMobile;
        this.empSal = empSal;
    }

}
