package com.testowy.logic;

import com.testowy.model.Department;
import com.testowy.model.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    private DepartmentRepository repository;

    DepartmentService(final DepartmentRepository repository) {
        this.repository = repository;
    }

    public List<String> allDepartmentsName(){
        return repository
                .findAll()
                .stream()
                .map(Department::getDepartmentName).toList();
    }

    public List<String> departmentNamesInBase(Department current){
        return repository
                .findAll()
                .stream()
                .map(Department::getDepartmentName)
                .filter(x -> x.equals(current.getDepartmentName())).toList();
    }

    public List<String> departmentAdressInBase(Department current){
        return repository
                .findAll()
                .stream()
                .map(Department::getDepartmentName)
                .filter(x -> x.equals(current.getDepartmentAdress())).toList();
    }
    public List<String> allDepartmentsAdress(){
        return repository
                .findAll()
                .stream()
                .map(Department::getDepartmentAdress).toList();
    }



}
