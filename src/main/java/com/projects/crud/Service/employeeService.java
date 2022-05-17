package com.projects.crud.Service;

import java.util.List;
import java.util.Optional;

import com.projects.crud.Entity.Employee;

public interface employeeService 
{
    /**
     * Method : save
     * @return Employee <Object>
     * @param : Employee
     */    
    public Employee save(Employee employee);

    /**
     * Method : getEmployeeById
     * @return : Optional<Employee>
     * @param : Employee_Id Integer
     */
    public Optional<Employee> getEmployeeById(Integer EmployeeId);

    /**
     * Method : getAllEmployees
     * @return : List<Employee>
     * @param : None
     */
    public List<Employee> getAllEmployees();

    /**
     * Method : deleteEmployeeById
     * @return : String
     * @param : Employee_Id Integer
     */
    public String deleteEmployeeById(Integer EmployeeId);

    /**
     * Method : updateEmployee
     * @return : Employee
     * @param : Employee_Id Integer
     */
    public Employee updateEmployee(Employee employee);

    /**
     * Method : getEmployeesByRole
     * @return : List<Employee>
     * @param : <String> Role
     */
    public List<Employee> getEmployeesByRole(String role);

    /**
     * Method : incrementSalaryByRole
     * @return : List<Employee>
     * @param : <String> Role, Float percentage
     */
    public List<Employee> incrementSalaryByRole(String role, Integer percentage);
}
