package com.projects.crud.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "`Employee`")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Employee_Id", nullable = false, unique = true)
    private Integer employeeId;

    @Column(name = "Employee_Name", nullable = false)
    private String employeeName;

    @Column(name = "Employee_Email", unique = true)
    private String employeeEmail;

    @Column(name = "Employee_PhoneNumber", unique = true)
    private String employeePhoneNumber;
    
    @Column(name = "Employee_Level", nullable = false)
    private String employeeLevel;

    @Column(name = "Employee_Role", nullable = false)
    private String employeeRole;
    
    @Column(name = "Employee_Salary")
    private Float employeeSalary;

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeePhoneNumber() {
        return employeePhoneNumber;
    }

    public void setEmployeePhoneNumber(String employeePhoneNumber) {
        this.employeePhoneNumber = employeePhoneNumber;
    }

    public String getEmployeeLevel() {
        return employeeLevel;
    }

    public void setEmployeeLevel(String employeeLevel) {
        this.employeeLevel = employeeLevel;
    }

    public String getEmployeeRole() {
        return employeeRole;
    }

    public void setEmployeeRole(String employeeRole) {
        this.employeeRole = employeeRole;
    }

    public Float getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(Float employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    
}
