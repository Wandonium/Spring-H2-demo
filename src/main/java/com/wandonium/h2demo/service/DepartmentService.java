package com.wandonium.h2demo.service;

import com.wandonium.h2demo.entity.Department;
import com.wandonium.h2demo.error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {
    public Department saveDepartment(Department department);

    public List<Department> getDepartments();

    public Department getDepartment(Long departmentId) throws DepartmentNotFoundException;

    public void deleteDepartment(Long departmentId);

    public Department updateDepartment(Long departmentId, Department department);

    public Department getByName(String departmentName);
}
