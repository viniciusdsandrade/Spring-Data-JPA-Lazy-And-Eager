package com.restful.lazydemonstration.service.impl;

import com.restful.lazydemonstration.dto.DepartmentDTO;
import com.restful.lazydemonstration.dto.EmployeeMinDTO;
import com.restful.lazydemonstration.entity.Department;
import com.restful.lazydemonstration.entity.Employee;
import com.restful.lazydemonstration.repository.DepartmentRepository;
import com.restful.lazydemonstration.service.DepartmentService;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Transactional(readOnly = true)
    public DepartmentDTO findById(Long id) {

        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Department not found with id: " + id));

        return new DepartmentDTO(department);
    }

    @Transactional(readOnly = true)
    public List<EmployeeMinDTO> findEmployeesByDepartment(Long id) {

        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Department not found with id: " + id));

        List<Employee> list = department.getEmployees();

        if (list == null)
            return Collections.emptyList();

        return list.stream().map(EmployeeMinDTO::new).toList();
    }
}