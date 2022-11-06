package com.msconsult.department.controller;

import com.msconsult.department.entity.Department;
import com.msconsult.department.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/departments")
@Slf4j
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/")
    public Department saveDepartment(@RequestBody Department department){
        log.info("Inside the SaveDepartment method in Department Controller.");
       return  departmentService.saveDepartment(department);
    }

    @GetMapping("/{id}")
    public Department findDepartmentById(@PathVariable ("id") Long departmentId){
        log.info("Inside the findDepartmentById method in Department Controller.");
        return departmentService.findDepartmentById(departmentId);

    }
}
