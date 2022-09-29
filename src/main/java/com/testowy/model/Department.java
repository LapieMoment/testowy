package com.testowy.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "departments")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDepartment;

    @NotEmpty(message = "Nazwa wydziału nie może być pusta")
    private String departmentName;

    @NotEmpty(message = "Nazwa adresu nie może być pusta")
    private String departmentAdress;


    public Department() {
    }

    public String getDepartmentAdress() {
        return departmentAdress;
    }

    public void setDepartmentAdress(final String departmentAdress) {
        this.departmentAdress = departmentAdress;
    }

    public int getIdDepartment() {
        return idDepartment;
    }

    public void setIdDepartment(final int idDepartment) {
        this.idDepartment = idDepartment;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(final String departmentName) {
        this.departmentName = departmentName;
    }
}

