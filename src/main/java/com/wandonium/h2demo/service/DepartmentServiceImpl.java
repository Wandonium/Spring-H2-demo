package com.wandonium.h2demo.service;

import com.wandonium.h2demo.entity.Department;
import com.wandonium.h2demo.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> getDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartment(Long departmentId) {
        return departmentRepository.findById(departmentId).get();
    }

    @Override
    public void deleteDepartment(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    @Override
    public Department updateDepartment(Long departmentId, Department department) {
        Department updatedDepartment = departmentRepository.findById(departmentId).get();
        if(department.getDepartmentCode() != null &&
                !department.getDepartmentCode().isEmpty()) {
            updatedDepartment.setDepartmentCode(department.getDepartmentCode());
        }

        if(department.getDepartmentName() != null &&
                !department.getDepartmentName().isEmpty()) {
            updatedDepartment.setDepartmentName(department.getDepartmentName());
        }

        if(department.getDepartmentAddress() != null &&
        !department.getDepartmentAddress().isEmpty()) {
            updatedDepartment.setDepartmentAddress(department.getDepartmentAddress());
        }

        return departmentRepository.save(updatedDepartment);
    }

    @Override
    public Department getByName(String departmentName) {
        return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
    }
}
