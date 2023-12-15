package com.restful.lazydemonstration.controller;

import com.restful.lazydemonstration.dto.EmployeeDepartmentDTO;
import com.restful.lazydemonstration.dto.EmployeeMinDTO;
import com.restful.lazydemonstration.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/employees")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(value = "/{id}/min")
    public ResponseEntity<EmployeeMinDTO> findByIdMin(@PathVariable Long id) {
        EmployeeMinDTO obj = employeeService.findByIdMin(id);
        return ResponseEntity.ok(obj);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<EmployeeDepartmentDTO> findByIdWithDepartment(@PathVariable Long id) {
        EmployeeDepartmentDTO obj = employeeService.findByIdWithDepartment(id);
        return ResponseEntity.ok(obj);
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDepartmentDTO>> findEmployeesWithDepartments() {
        List<EmployeeDepartmentDTO> list = employeeService.findEmployeesWithDepartments();
        return ResponseEntity.ok(list);
    }
}
