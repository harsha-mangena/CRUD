package com.projects.crud.RepositoryTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import com.projects.crud.Application;
import com.projects.crud.Entity.Employee;
import com.projects.crud.Repository.EmployeeRepository;
import com.projects.crud.Service.employeeService;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;

@TestInstance(Lifecycle.PER_CLASS)
@DataJpaTest
@ContextConfiguration(classes=Application.class)
public class employeeRepositoryTest 
{
    @Autowired 
    EmployeeRepository  employeeRepository;

    @MockBean
    employeeService employeeService;
 
    @BeforeAll
    void setUp()
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
                
        Employee employee2 = Employee.builder()
                             .employeeId(2)
                             .employeeName("Lahari Mangena")
                             .employeeEmail("manngenalahari@xver.com")
                             .employeePhoneNumber("852364712")
                             .employeeLevel("AL1")
                             .employeeRole("Associate(Development) - I")
                             .employeeSalary((float)8000000)
                             .build();

        Employee employee3 = Employee.builder()
                             .employeeId(3)
                             .employeeName("Chinnu Dasari")
                             .employeeEmail("dasari.chinnu@xver.com")
                             .employeePhoneNumber("753951222")
                             .employeeLevel("L2")
                             .employeeRole("SDE-II")
                             .employeeSalary((float)4200000)
                             .build();

        employeeRepository.save(employee1);
        employeeRepository.save(employee2);
        employeeRepository.save(employee3);
                    
    }

    /**
     * Method : test for getting all the employees
     */

    @Test
    void testGetAllEmployeesWithData()
    {
        List<Employee> employees = employeeRepository.findAll();
        assertEquals(3, employees.size());
    }

    /**
     * Method : test for getting employee by Id
     */
    @Test
    void testForGettingEmployeeById()
    {
        Employee employee = employeeRepository.findById(3).get();

        assertNotNull(employee);
        assertEquals("dasari.chinnu@xver.com", employee.getEmployeeEmail());
    }

    /**
     * Method : test for Deleting a employee
     */

    @Test
    void testForDeletingEmployee()
    {
        employeeRepository.deleteById(1);

        Optional<Employee> employee = employeeRepository.findById(1);

        assertEquals(Optional.empty(), employee);
    }

    /**
     * Method :  test for Adding employee to repository
     */

    @Test
    void testForAddingEmployee()
    {
        Employee newEmployee = Employee.builder()       
                                .employeeId(4)
                                .employeeName("Harinath")
                                .employeeEmail("harinath@xver.com")
                                .employeePhoneNumber("658420136")
                                .employeeLevel("PM - 1")
                                .employeeRole("Project Manager - Field")
                                .employeeSalary((float)2400000)
                                .build();
                        
        employeeRepository.save(newEmployee);

        Employee employee = employeeRepository.findById(4).get();

        assertEquals(employee.getEmployeeName(), "Harinath");
    }

    /**
     * Method test to update the existing employee
     */
    @Test
    void testForUpdatingEmployee()
    {
        Employee updatedEmployee = Employee.builder()
                                  .employeeId(5)
                                  .employeeName("Vamsee Sai")
                                  .employeeEmail("sai.vamsee99@xver.com")
                                  .employeePhoneNumber("863412597")
                                  .employeeLevel("MP - 1")
                                  .employeeRole("PM - 2")
                                  .employeeSalary((float)6000000)
                                  .build();

        when(employeeService.updateEmployee(updatedEmployee)).thenReturn(updatedEmployee);

        assertEquals(updatedEmployee, employeeService.updateEmployee(updatedEmployee));
    }
    
}
