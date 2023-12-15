package com.restful.lazydemonstration.service;

import com.restful.lazydemonstration.dto.DepartmentDTO;
import com.restful.lazydemonstration.dto.EmployeeMinDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface DepartmentService {

    @Transactional(readOnly = true)
    DepartmentDTO findById(Long id);
    
    @Transactional(readOnly = true)
    List<EmployeeMinDTO> findEmployeesByDepartment(Long id);
}
