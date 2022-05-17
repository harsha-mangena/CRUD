package com.projects.crud.Repository;

import java.util.List;

import javax.transaction.Transactional;

import com.projects.crud.Entity.Employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository("employeeRepository")
public interface EmployeeRepository extends JpaRepository<Employee, Integer>
{

    //Finding By Employee Role
    public List<Employee> findByemployeeRole(String Role);

    //Incrementing Employee Salary by 25% if SDE1
    @Transactional
    @Modifying
    @Query("update Employee e SET e.employeeSalary = e.employeeSalary + e.employeeSalary*(?2/100) WHERE e.employeeRole = ?1")
    public void incrementSalaryByRole(String Employee_Role, Integer percentage);
}
