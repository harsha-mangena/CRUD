package com.projects.crud.Controllers;

import java.util.List;

import com.projects.crud.Entity.Employee;
import com.projects.crud.Service.employeeServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController 
{

    @Autowired
    employeeServiceImpl employeeService;

    /**
     * API : /employee
     * TYPE : POST
     * @return : Employee <Object>
     * @param : Employee 
     */
    @PostMapping("/employee")
    private Employee saveEmployee(@RequestBody Employee employee)
    {
        return employeeService.save(employee);
    }

    /**
     * API : /employee/all
     * TYPE : GET
     * @return : List<Employee>
     * @param : None
     */
    @GetMapping("/employees/all")
    private List<Employee> getAllEmployees()
    {
        return employeeService.getAllEmployees();
    }

    /**
     * API : /employee/{employee_Id}
     * TYPE : GET
     * @return : Employee <Object>
     * @param : employee_Id <integer>
     */
    @GetMapping("employee/{employee_Id}")
    private Employee getEmployeeById(@PathVariable("employee_Id") Integer EmployeeId)
    {
        return employeeService.getEmployeeById(EmployeeId).get();
    }

    /**
     * API : /delete/employee{employee_Id}
     * TYPE : DELETE
     * @return : Employee
     * @param : Employee <Object>
     */
    @DeleteMapping("/delete/employee/{employee_Id}")
    private String deleteEmployee(@PathVariable("employee_Id") Integer EmployeeId)
    {
        return employeeService.deleteEmployeeById(EmployeeId);
    }

    /**
     * API : /update/
     * TYPE : PUT
     * @return : Employee
     * @param : Employee <Object>
     */
    @PutMapping("/update")
    private Employee updateEmployee(@RequestBody Employee employee)
    {
        return employeeService.updateEmployee(employee);
    }

    /**
     * API : /employee/{employee_Role}
     * TYPE : GET
     * @return : List<Employee> with specific role
     * @param : <String> Role
     */
    @GetMapping("/employees/all/{employee_Role}")
    private List<Employee> getEmployeesByRole(@PathVariable("employee_Role") String role)
    {
        return employeeService.getEmployeesByRole(role);
    }

    /**
     * API : /employee/increment/{employee_Role}/{percentage}
     * TYPE : GET 
     * @return : List<Employee> with Roles
     * @param : <String> Role, Float percentage 
     */
    @GetMapping("/employee/increment/{employee_Role}/{percentage}")
    private List<Employee> incrementSalaryByRole(@PathVariable String employee_Role,@PathVariable Integer percentage) 
    {
        return employeeService.incrementSalaryByRole(employee_Role, percentage);
    }


}
