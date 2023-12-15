package com.restful.lazydemonstration.controller;

import com.restful.lazydemonstration.dto.DepartmentDTO;
import com.restful.lazydemonstration.dto.EmployeeMinDTO;
import com.restful.lazydemonstration.service.DepartmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/departments")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<DepartmentDTO> findById(@PathVariable Long id) {
        DepartmentDTO obj = departmentService.findById(id);
        return ResponseEntity.ok(obj);
    }

    @GetMapping(value = "/{id}/employees")
    public ResponseEntity<List<EmployeeMinDTO>> findEmployeesByDepartment(@PathVariable Long id) {
        List<EmployeeMinDTO> list = departmentService.findEmployeesByDepartment(id);
        return ResponseEntity.ok(list);
    }
}