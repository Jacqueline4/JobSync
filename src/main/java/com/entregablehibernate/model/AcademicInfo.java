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
@Table(name = "estudios")
public class AcademicInfo {

    @Column(name = "fechaInicio")
    private LocalDate initDate;

    @Id // esto ya da por hecho que es PK
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "activoEstudios")
    private boolean current;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})//aqui puede haber varios parametros
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "nombreTitulo")
    private String title;

    @Column(name = "fechaFin")
    private LocalDate endDate;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "institucion")
    private Institution institution;

    @Column(name = "puntuacion")
    private float meanScore;

    public AcademicInfo() {
    }

    public AcademicInfo(User user, Institution institution) {
        this.user = user;
        this.institution = institution;
    }

    public AcademicInfo(LocalDate initDate, String title, LocalDate endDate, Institution institution, float meanScore) {
        this.initDate = initDate;
        this.title = title;
        this.endDate = endDate;
        this.institution = institution;
        this.meanScore = meanScore;
    }

    public AcademicInfo(LocalDate initDate, Long id, boolean current, User user, String title, LocalDate endDate, Institution institution, float meanScore) {
        this.initDate = initDate;
        this.id = id;
        this.current = current;
        this.user = user;
        this.title = title;
        this.endDate = endDate;
        this.institution = institution;
        this.meanScore = meanScore;
    }

    public float getMeanScore() {
        return meanScore;
    }

    public void setMeanScore(float meanScore) {
        this.meanScore = meanScore;
    }

    public LocalDate getInitDate() {
        return initDate;
    }

    public void setInitDate(LocalDate initDate) {
        this.initDate = initDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Institution getInstitution() {
        return institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }

}
