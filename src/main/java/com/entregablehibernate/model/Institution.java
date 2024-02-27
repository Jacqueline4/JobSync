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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jacqueline
 */
@Entity
@Table(name = "instituciones")
public class Institution {

    @Id // esto ya da por hecho que es PK
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", unique = true)
    private String name;

    @OneToMany(mappedBy = "institution", cascade = CascadeType.ALL)
    private List<AcademicInfo> academicList = new ArrayList<>();

    public Institution(String name, List<AcademicInfo> academicList) {
        this.name = name;
        this.academicList = academicList;
    }

    public Institution() {
    }

    public Institution(String name) {
        this.name = name;
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

    public List<AcademicInfo> getAcademicList() {
        return academicList;
    }

    public void setAcademicList(List<AcademicInfo> academicList) {
        this.academicList = academicList;
    }

}
