package com.testowy.controller;

import com.testowy.logic.DepartmentService;
import com.testowy.model.Department;
import com.testowy.model.DepartmentRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/view")
class ViewController {

    private final DepartmentRepository repository;
    private DepartmentService departmentService;

    ViewController(final DepartmentRepository repository, final DepartmentService departmentService) {
        this.repository = repository;

        this.departmentService = departmentService;
    }

    @GetMapping
    String showView(Model model){
        List<String> allDepartmentsName = departmentService.allDepartmentsName();
        model.addAttribute("allDepartmentsName",allDepartmentsName);
        model.addAttribute("department", new Department());
        return "indextestowy";
    }

    @PostMapping
    String createDepartment(
            @ModelAttribute("department") @Valid Department current,
            BindingResult result,
            Model model
    ){
        if(result.hasErrors()) {
            return "indextestowy";
        }

        List<String> stringListDepartment = departmentService.departmentNamesInBase(current);
        List<String> stringListAdress = departmentService.departmentAdressInBase(current);

        if(!stringListDepartment.isEmpty()){
            model.addAttribute("warningMessageDN","Dział o tej nazwie już istnieje");
            if(!stringListAdress.isEmpty()){
                model.addAttribute("warningMessageDA","Dział o tym adresie już istnieje");
                return "indextestowy";
            }
            return "indextestowy";
        }


        repository.save(current);
        model.addAttribute("acceptMessage","Udało się dodać department");
        return "indextestowy";
    }




}
