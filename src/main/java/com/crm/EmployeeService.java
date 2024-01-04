package com.crm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeById(long employeeId) {
        return employeeRepository.findById(employeeId);
    }

    public Employee createEmployee(Employee employee) {
        // In a real application, you might add validation or other business logic
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(long employeeId, Employee updatedEmployee) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId);
        if (optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();
            employee.setFirstName(updatedEmployee.getFirstName());
            employee.setLastName(updatedEmployee.getLastName());
            employee.setDateOfBirth(updatedEmployee.getDateOfBirth());
            employee.setEmail(updatedEmployee.getEmail());
            employee.setPhoneNumber(updatedEmployee.getPhoneNumber());
            employee.setAddress(updatedEmployee.getAddress());
            return employeeRepository.save(employee);
        }
        return null; // Handle not found scenario
    }

    public void deleteEmployee(long employeeId) {
        employeeRepository.deleteById(employeeId);
    }
}

