package com.projects.crud.Service;

import java.util.List;
import java.util.Optional;

import com.projects.crud.Entity.Employee;
import com.projects.crud.Repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("employeeService")
public class employeeServiceImpl implements employeeService 
{

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public Employee save(Employee employee) 
    {
        return employeeRepository.save(employee);
    }

    @Override
    public Optional<Employee> getEmployeeById(Integer EmployeeId) 
    {
       return employeeRepository.findById(EmployeeId);
    }

    @Override
    public List<Employee> getAllEmployees() 
    {
        return employeeRepository.findAll();
    }

    @Override
    public String deleteEmployeeById(Integer EmployeeId) 
    {
       /* Checking if the employee with given Id in DB or not.
        * Find the employee with id, If Object is Null , No employee found with given Id.
        * Else delete the employee
        */
       Employee currentEmployee = employeeRepository.findById(EmployeeId).get();
       if(currentEmployee == null)
       {
           return "Can't find employee with given Id : " + EmployeeId + "." ;
       }

       employeeRepository.deleteById(EmployeeId);
       return "Employee with given Id : " + EmployeeId + " deleted successfully." ;
    }

    @Override
    public Employee updateEmployee(Employee employee) 
    {
        Employee currentEmployee = employeeRepository.findById(employee.getEmployeeId()).get();

        if(currentEmployee == null)
        {
            return employeeRepository.save(employee);
        }

        //Employee Name
        if(currentEmployee != null && ! currentEmployee.getEmployeeName().equals(employee.getEmployeeName()))
        {
            currentEmployee.setEmployeeName(employee.getEmployeeName());
        }

        //Employee Email
        if(currentEmployee != null && ! currentEmployee.getEmployeeEmail().equals(employee.getEmployeeEmail()))
        {
            currentEmployee.setEmployeeEmail(employee.getEmployeeEmail());
        }

        //Employee PhoneNumber
        if(currentEmployee != null && ! currentEmployee.getEmployeePhoneNumber().equals(employee.getEmployeePhoneNumber()))
        {
            currentEmployee.setEmployeePhoneNumber(employee.getEmployeePhoneNumber());
        }

        //Employee Salary
        if(currentEmployee != null && currentEmployee.getEmployeeSalary() != employee.getEmployeeSalary())
        {
            currentEmployee.setEmployeeSalary(employee.getEmployeeSalary());
        }

        //Employee Level
        if(currentEmployee != null && ! currentEmployee.getEmployeeLevel().equals(employee.getEmployeeLevel()))
        {
            currentEmployee.setEmployeeLevel(employee.getEmployeeLevel());
        }

        //Employee Role
        if(currentEmployee != null && ! currentEmployee.getEmployeeRole().equals(employee.getEmployeeRole()))
        {
            currentEmployee.setEmployeeRole(employee.getEmployeeRole());
        }
        
        return employeeRepository.save(currentEmployee);
    }

    @Override
    public List<Employee> getEmployeesByRole(String role) {
        return employeeRepository.findByemployeeRole(role);
    }

    @Override
    public List<Employee> incrementSalaryByRole(String role, Integer percentage) 
    {
        //Updating the salary by role and department
        employeeRepository.incrementSalaryByRole(role, percentage);

        //Returning the salary after increasing the salary 
        return employeeRepository.findByemployeeRole(role);
    }
    
}
