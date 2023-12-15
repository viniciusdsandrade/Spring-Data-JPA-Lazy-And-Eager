package com.restful.lazydemonstration.service.impl;

import com.restful.lazydemonstration.dto.EmployeeDepartmentDTO;
import com.restful.lazydemonstration.dto.EmployeeMinDTO;
import com.restful.lazydemonstration.entity.Employee;
import com.restful.lazydemonstration.repository.EmployeeRepository;
import com.restful.lazydemonstration.service.EmployeeService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public EmployeeMinDTO findByIdMin(Long id) {

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Employee not found with id: " + id));

        return new EmployeeMinDTO(employee);
    }

    @Transactional(readOnly = true)
    public EmployeeDepartmentDTO findByIdWithDepartment(Long id) {

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Employee not found with id: " + id));

        return new EmployeeDepartmentDTO(employee);
    }

    @Transactional(readOnly = true)
    public List<EmployeeDepartmentDTO> findEmployeesWithDepartments() {

        List<Employee> employees = employeeRepository.findEmployeesWithDepartments();

        if (employees == null)
            return Collections.emptyList();

        return employees.stream().map(EmployeeDepartmentDTO::new).collect(Collectors.toList());
    }
}