package com.testowy.adapter;

import com.testowy.model.Department;
import com.testowy.model.DepartmentRepository;
import org.springframework.data.jpa.repository.JpaRepository;

interface SqlDepartmentRepository  extends DepartmentRepository, JpaRepository<Department, Integer> {
}
