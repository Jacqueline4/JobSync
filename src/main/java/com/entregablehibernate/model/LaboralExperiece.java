/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.entregablehibernate.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;

/**
 *
 * @author jacqueline
 */
@Entity
@Table(name = "experiencia_laboral")
public class LaboralExperiece {

    @Id // esto ya da por hecho que es PK
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fechaInicio")
    private LocalDate initDate;

    @Column(name = "activoLaboral")
    private boolean current;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})//aqui puede haber varios parametros
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "nombre_puesto")
    private String jobTitle;

    @Column(name = "descripcion")
    private String description;

    @Column(name = "direccion")
    private String location;

    @Column(name = "fechaFin")
    private LocalDate endDate;

    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Company company;

    public LaboralExperiece() {
    }

    public LaboralExperiece( Company company,User user) {
        this.user = user;
        this.company = company;
    }

    public LaboralExperiece(String jobTitle, String description, String location, Company company) {
        this.jobTitle = jobTitle;
        this.description = description;
        this.location = location;
        this.company = company;
    }
    

    public LaboralExperiece(LocalDate initDate, boolean current, User user, String jobTitle, String description, String location, LocalDate endDate, Company company) {
        this.initDate = initDate;
        this.current = current;
        this.user = user;
        this.jobTitle = jobTitle;
        this.description = description;
        this.location = location;
        this.endDate = endDate;
        this.company = company;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getInitDate() {
        return initDate;
    }

    public void setInitDate(LocalDate initDate) {
        this.initDate = initDate;
    }

    public boolean isCurrent() {
        return current;
    }

    public void setCurrent(boolean current) {
        this.current = current;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }


}
