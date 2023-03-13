package com.wandonium.h2demo.service;

import com.wandonium.h2demo.entity.Department;
import com.wandonium.h2demo.error.DepartmentNotFoundException;
import com.wandonium.h2demo.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public Department getDepartment(Long departmentId) throws DepartmentNotFoundException {
        Optional<Department> department = departmentRepository.findById(departmentId);
        if(department.isPresent()) {
            return department.get();
        } else {
            throw new DepartmentNotFoundException("Error! Department with ID "
                    + departmentId + " not found in DB!");
        }
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
