package com.testowy.model;

import java.util.List;
import java.util.Optional;

public interface DepartmentRepository {
    //GET
    boolean existsById(Integer id);
    Optional<Department> findById(Integer id);
    List<Department> findAll();

    //POST
    Department save(Department entity);

    //PUT

    //PATCH

    //DELETE
    void delete(Department entity);

}

