package com.restful.lazydemonstration.controller;

import com.restful.lazydemonstration.dto.EmployeeDepartmentDTO;
import com.restful.lazydemonstration.dto.EmployeeMinDTO;
import com.restful.lazydemonstration.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
        return ResponseEntity.of(Optional.ofNullable(employeeService.findByIdMin(id)));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<EmployeeDepartmentDTO> findByIdWithDepartment(@PathVariable Long id) {
        return ResponseEntity.of(Optional.ofNullable(employeeService.findByIdWithDepartment(id)));
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDepartmentDTO>> findEmployeesWithDepartments() {
        List<EmployeeDepartmentDTO> list = employeeService.findEmployeesWithDepartments();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/name/{name}")
    public ResponseEntity<List<EmployeeMinDTO>> findByNameIgnoreCase(@PathVariable String name) {
        List<EmployeeMinDTO> list = employeeService.findByNameIgnoreCase(name);

        return list.isEmpty()
                ? ResponseEntity.noContent().build() // Retorna 204 No Content se a lista estiver vazia
                : ResponseEntity.ok().body(list);
    }
}
