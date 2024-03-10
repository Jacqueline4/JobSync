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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jacqueline
 */
@Entity
@Table(name = "usuarios")
public class User {

    @Id // esto ya da por hecho que es PK
    @GeneratedValue(strategy = GenerationType.IDENTITY)//esto es para la autoincremento del ID
    private Long id;

    @Column(name = "nombre")//por si en la bbdd la columna se llama nombre
    private String name;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "user_skills",
//            uniqueConstraints = {
//                @UniqueConstraint(columnNames = {"user_id", "skills_id"})},
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "skills_id")
    )
    private List<Skill> skillsList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL,fetch =FetchType.EAGER)
    private List<AcademicInfo> academicList = new ArrayList<>();

    @Column(name = "telefono")
    private int telephone;

    @Column(name = "descripcion")
    private String description;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL,fetch =FetchType.EAGER)
    private List<LaboralExperiece> laboralExpList = new ArrayList<>();

    @Column(name = "correo")
    private String mail;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL,fetch =FetchType.EAGER)
    private List<Candidature> candidaturesList = new ArrayList<>();

    private String password;

    public User() {
    }

    public User(String name, int telephone, String password, String mail) {
        this.name = name;
        this.telephone = telephone;
        this.password = password;
        this.mail = mail;
    }

    public User(String name, String description, int telephone, String mail) {
        this.name = name;
        this.telephone = telephone;
        this.description = description;
        this.mail = mail;
    }

    public User(String name, List<Skill> skillsList, List<AcademicInfo> academicList, int telephone, String description, List<LaboralExperiece> laboralExpList, String mail, List<Candidature> candidaturesList) {
        this.name = name;
        this.skillsList = skillsList;
        this.academicList = academicList;
        this.telephone = telephone;
        this.description = description;
        this.laboralExpList = laboralExpList;
        this.mail = mail;
        this.candidaturesList = candidaturesList;
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

    public List<Skill> getSkillsList() {
        return skillsList;
    }

    public void setSkillsList(List<Skill> skillsList) {
        this.skillsList = skillsList;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public List<AcademicInfo> getAcademicList() {
        return academicList;
    }

    public void setAcademicList(List<AcademicInfo> academicList) {
        this.academicList = academicList;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<LaboralExperiece> getLaboralExpList() {
        return laboralExpList;
    }

    public void setLaboralExpList(List<LaboralExperiece> laboralExpList) {
        this.laboralExpList = laboralExpList;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public List<Candidature> getCandidaturesList() {
        return candidaturesList;
    }

    public void setCandidaturesList(List<Candidature> candidaturesList) {
        this.candidaturesList = candidaturesList;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name=" + name + ", telephone=" + telephone + ", description=" + description + '}';
    }
    
}
