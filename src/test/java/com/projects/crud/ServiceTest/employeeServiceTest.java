package com.projects.crud.ServiceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.projects.crud.Entity.Employee;
import com.projects.crud.Repository.EmployeeRepository;
import com.projects.crud.Service.employeeServiceImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@TestInstance(Lifecycle.PER_CLASS)
@SpringBootTest
public class employeeServiceTest 
{
    @Autowired 
    employeeServiceImpl employeeService;

    @MockBean
    EmployeeRepository employeeRepository;

    @BeforeEach
    void setUp()
    {

    }

    /**
     * Method : test for Adding Employee
     */
    @Test
    void testAddingEmployee()
    {
        Employee employee1 = Employee.builder()
                             .employeeId(1)
                             .employeeName("Harsha Mangena")
                             .employeeEmail("harsha.managena@xver.com")
                             .employeePhoneNumber("65478912030")
                             .employeeLevel("L1")
                             .employeeRole("SDE-I")
                             .employeeSalary((float)1000000)
                             .build();

        when(employeeRepository.save(employee1)).thenReturn(employee1);

        assertEquals(1, employeeService.save(employee1).getEmployeeId());

    }

    /**
     * Method : test for getting All Employees
     */
    @Test
    void testForGettingAllEmployees()
    {
        List<Employee> employees = new ArrayList<Employee>();

        employees.add(new Employee());
        employees.add(new Employee());
        employees.add(new Employee());

        when(employeeRepository.findAll()).thenReturn(employees);

        assertEquals(3, employeeService.getAllEmployees().size());
        
    }

    /**
     * Method : test for updating employee
     */
    @Test
    void testForUpdatingEmployee()
    {
        Employee beforeUpdate = Employee.builder()
                                .employeeId(1)
                                .employeeName("Test1")
                                .employeeEmail("TestFor@some.com")
                                .employeePhoneNumber("963258741")
                                .employeeLevel("L1")
                                .employeeRole("sde-i")
                                .employeeSalary((float)1800000)
                                .build();

        when(employeeRepository.save(beforeUpdate)).thenReturn(beforeUpdate);

        assertEquals("sde-i", employeeService.save(beforeUpdate).getEmployeeRole());
        
    }

    /**
     * Method :  Test for gettingEmployeeByRole
     */
    @Test
    void testForGettingEmployeeByRole()
    {
        Employee employee = Employee.builder()
                                .employeeId(1)
                                .employeeName("Test1")
                                .employeeEmail("TestFor@some.com")
                                .employeePhoneNumber("963258741")
                                .employeeLevel("L1")
                                .employeeRole("sde-i")
                                .employeeSalary((float)1800000)
                                .build();
        Employee employee2 = Employee.builder()
                                    .employeeId(2)
                                    .employeeName("Test2")
                                    .employeeEmail("Test2For@some.com")
                                    .employeePhoneNumber("963258741")
                                    .employeeLevel("L1")
                                    .employeeRole("sde-i")
                                    .employeeSalary((float)1800000)
                                    .build();
        
        List<Employee> employeeList = new ArrayList<Employee>();
        employeeList.add(employee);
        employeeList.add(employee2);

        when(employeeRepository.findByemployeeRole("sde-i")).thenReturn(employeeList);

        assertNotNull(employeeService.getEmployeesByRole("sde-i"));

    }

}