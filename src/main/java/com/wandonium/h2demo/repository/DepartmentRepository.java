package com.wandonium.h2demo.repository;

import com.wandonium.h2demo.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class DepartmentRepository extends JpaRepository<Department, long> {
}
