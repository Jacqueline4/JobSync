/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.entregablehibernate.model;

import jakarta.persistence.ManyToMany;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jacqueline
 */
@Entity
@Table(name = "habilidades")
public class Skill {

    @Id // esto ya da por hecho que es PK
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String name;

    @ManyToMany(mappedBy = "skillsList")
    private List<User> userList = new ArrayList<>();

//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(
//            name = "job_offers_skills",
//            joinColumns = @JoinColumn(name = "jobOffer_id"),
//            inverseJoinColumns = @JoinColumn(name = "skills_id")
//    )
//    private List<JobOffer> jobOfferList = new ArrayList<>();

    public Skill() {
    }

    public Skill(String name) {
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

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public Skill(String name, List<User> userList, List<JobOffer> jobOfferList) {
        this.name = name;
        this.userList = userList;
//        this.jobOfferList = jobOfferList;
    }

//    public List<JobOffer> getJobOfferList() {
//        return jobOfferList;
//    }
//
//    public void setJobOfferList(List<JobOffer> jobOfferList) {
//        this.jobOfferList = jobOfferList;
//    }

    @Override
    public String toString() {
        return "Skill{" + "id=" + id + ", name=" + name + '}';
    }

}
