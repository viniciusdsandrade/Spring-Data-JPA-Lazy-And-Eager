package com.restful.lazydemonstration.service;

import com.restful.lazydemonstration.dto.EmployeeDepartmentDTO;
import com.restful.lazydemonstration.dto.EmployeeMinDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface EmployeeService {

    @Transactional(readOnly = true)
    EmployeeMinDTO findByIdMin(Long id);

    @Transactional(readOnly = true)
    EmployeeDepartmentDTO findByIdWithDepartment(Long id);

    @Transactional(readOnly = true)
    List<EmployeeDepartmentDTO> findEmployeesWithDepartments();
}
