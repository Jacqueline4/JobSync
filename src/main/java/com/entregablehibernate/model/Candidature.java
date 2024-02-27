/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.entregablehibernate.model;

import com.entregablehibernate.utils.Status;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

/**
 *
 * @author jacqueline
 */
@Entity
@Table(name = "candidatura")//, uniqueConstraints = {@UniqueConstraint(columnNames = { "nombreBBDD", "otroBBDD"})}
public class Candidature {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})//aqui puede haber varios parametros
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "estado")
    private Status status;

    @Column(name = "convertidor_ruta")
    private String converLetterPath;

    @Column(name = "convertidor_cv")
    private String cvPath;

    @ManyToOne
    @JoinColumn(name = "oferta_trabajo_id")
    private JobOffer jobOffer;

    public Candidature(User user, Status status, String converLetterPath, String cvPath, JobOffer jobOffer) {
        this.user = user;
        this.status = status;
        this.converLetterPath = converLetterPath;
        this.cvPath = cvPath;
        this.jobOffer = jobOffer;
    }

    public Candidature() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getConverLetterPath() {
        return converLetterPath;
    }

    public void setConverLetterPath(String converLetterPath) {
        this.converLetterPath = converLetterPath;
    }

    public String getCvPath() {
        return cvPath;
    }

    public void setCvPath(String cvPath) {
        this.cvPath = cvPath;
    }

    public JobOffer getJobOffer() {
        return jobOffer;
    }

    public void setJobOffer(JobOffer jobOffer) {
        this.jobOffer = jobOffer;
    }
}
