package com.msconsult.department.service;

import com.msconsult.department.entity.Department;
import com.msconsult.department.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public Department saveDepartment(Department department) {
        log.info("Insside SaveDepartment in Department Service");
        return departmentRepository.save(department);
    }

    public Department findDepartmentById(Long departmentId) {
        log.info("Insside findDepartmentById in Department Service");
        return departmentRepository.findByDepartmentId(departmentId);
    }
}
