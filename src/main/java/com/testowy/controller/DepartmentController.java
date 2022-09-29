package com.testowy.controller;

import com.testowy.model.Department;
import com.testowy.model.DepartmentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;


@RestController
class DepartmentController {

    private final DepartmentRepository repository;

    DepartmentController(final DepartmentRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/departments")
    ResponseEntity<?> readAllNameEDepartments(){
        return ResponseEntity.ok(repository.findAll());
    }


//    @PutMapping("/departments/{id}")
//    ResponseEntity<?> readAllNamesDepartments(@PathVariable int id,@RequestBody Department employeeToUpdate){
//        if(!repository.existsById(id)){
//            return ResponseEntity.notFound().build();
//        }
//        repository.save(employeeToUpdate);
//        return ResponseEntity.noContent().build();
//    }

    @PostMapping
    ResponseEntity<?> addNewNameDepartment(@RequestBody @Valid Department departmentToUpdate){
        //sprawdzenie duplikatów
        List<String> stringList = repository.findAll()
                .stream()
                .map(Department::getDepartmentName)
                .filter(x -> x.equals(departmentToUpdate.getDepartmentName())).toList();

        if(!stringList.isEmpty())
            return ResponseEntity.status(409).build();

        Department result = repository.save(departmentToUpdate);
        return ResponseEntity.created(URI.create("/" + result.getIdDepartment())).body(result);
    }

}
