/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.entregablehibernate.model;

import com.entregablehibernate.utils.Status;
import com.entregablehibernate.utils.WorkDayType;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jacqueline
 */
@Entity
@Table(name = "oferta_trabajo")
public class JobOffer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titulo")
    private String title;

    @Column(name = "tipo_contrato")
    private WorkDayType workDayType;//private WorkDayType workDayType;//int

//    @ManyToMany(mappedBy = "jobOfferList", cascade = CascadeType.ALL)//, cascade = CascadeType.PERSIST
//    private List<Skill> skillsList = new ArrayList<>();
    
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "empresa_id")
    private Company company;
    
     @Column(name = "estado_oferta")
    private boolean open;

    @Column(name = "salario_max")
    private int maxSalary;

    @Column(name = "salario_min")
    private int minSalary;

    @Column(name = "candidados_requeridos")
    private int requiredCandidates;

    @Column(name = "direccion")
    private String location;

    @Column(name = "detalle")
    private String details;

    @OneToMany(mappedBy = "jobOffer", cascade = CascadeType.ALL)
    private List<Candidature> candidaturesList = new ArrayList<>();

    public JobOffer() {
    }

    public JobOffer(String title, Company company, int maxSalary, int minSalary, int requiredCandidates, String location, String details) {
        this.title = title;
        this.company = company;
        this.maxSalary = maxSalary;
        this.minSalary = minSalary;
        this.requiredCandidates = requiredCandidates;
        this.location = location;
        this.details = details;
    }

    public JobOffer(String title, WorkDayType workDayType, boolean open, int maxSalary, int minSalary, int requiredCandidates, String location, String details) {
        this.title = title;
        this.workDayType = workDayType;
        this.open = open;
        this.maxSalary = maxSalary;
        this.minSalary = minSalary;
        this.requiredCandidates = requiredCandidates;
        this.location = location;
        this.details = details;
    }

    public JobOffer(String tittle, WorkDayType workDayType, Company company, boolean open, int maxSalary, int minSalary, int requiredCandidates, String location, String details, List<Candidature> candidaturesList) {
        this.title = tittle;
        this.workDayType = workDayType;
        this.company = company;
        this.open = open;
        this.maxSalary = maxSalary;
        this.minSalary = minSalary;
        this.requiredCandidates = requiredCandidates;
        this.location = location;
        this.details = details;
        this.candidaturesList = candidaturesList;
    }

    public JobOffer(String title, Company company) {
        this.title = title;
        this.company = company;
    }


    public int getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(int maxSalary) {
        this.maxSalary = maxSalary;
    }

    public int getMinSalary() {
        
        return minSalary;
    }

    public void setMinSalary(int minSalary) {
        this.minSalary = minSalary;
    }

    public int getRequiredCandidates() {
        return requiredCandidates;
    }

    public void setRequiredCandidates(int requiredCandidates) {
        this.requiredCandidates = requiredCandidates;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTittle() {
        return title;
    }

    public void setTittle(String tittle) {
        this.title = tittle;
    }

    public WorkDayType getWorkDayType() {
        return workDayType;
    }

    public void setWorkDayType(WorkDayType workDayType) {
        this.workDayType = workDayType;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public List<Candidature> getCandidaturesList() {
        return candidaturesList;
    }

    public void setCandidaturesList(List<Candidature> candidaturesList) {
        this.candidaturesList = candidaturesList;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    @Override
    public String toString() {
        return  " Empresa: " + company.getName() + "\n Puesto: " + title + "\n Contrato: " + workDayType + "\n Rango Salarial: " +minSalary+" - "+ maxSalary + 
                "\n Número de vacantes: " + requiredCandidates + "\n Localidad: " + location + "\n Descripción: =" + details+ "\n";
    }

   

}
