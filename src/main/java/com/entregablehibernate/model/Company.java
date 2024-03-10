/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.entregablehibernate.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jacqueline
 */
@Entity
@Table(name = "empresa")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", unique = true)
    private String name;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<LaboralExperiece> laboralExperieceList = new ArrayList<>();

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<JobOffer> jobOffersList = new ArrayList<>();

    @Column(name = "descripcion")
    private String description;
    @Column(name = "contraseña")
    private String password;
    @Column(name = "email")
    private String email;

    public Company() {
    }

    public Company(String name) {
        this.name = name;
    }

    public Company(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public List<LaboralExperiece> getLaboralExperieceList() {
        return laboralExperieceList;
    }

    public void setLaboralExperieceList(List<LaboralExperiece> laboralExperieceList) {
        this.laboralExperieceList = laboralExperieceList;
    }

    public List<JobOffer> getJobOffersList() {
        return jobOffersList;
    }

    public void setJobOffersList(List<JobOffer> jobOffersList) {
        this.jobOffersList = jobOffersList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
