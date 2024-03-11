/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.entregablehibernate.services;

import com.entregablehibernate.controller.CompanyController;
import com.entregablehibernate.controller.JobOffersController;
import com.entregablehibernate.model.Candidature;
import com.entregablehibernate.model.Company;
import com.entregablehibernate.model.JobOffer;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jacqueline
 */
public class CompanyService {

    CompanyController cc = new CompanyController();
    JobOffersController jc = new JobOffersController();

    public void createCompany(Company co) {
        cc.createCompany(co);
    }

    public void updateCompany(Company co) {
        Company codb = cc.login(co);
        cc.updateCompany(codb);
    }

    public void removeCompany(Company co) {
        Company codb = cc.login(co);
        cc.removeCompany(codb);
    }

    public Company createCompany(String s) {
        Company co = new Company();
        return co;
    }

    public void printCompanyInfo(Company co) {
        System.out.println(co);
    }

    public void addJobOffer(Company co, JobOffer jo) {
        Company codb = cc.login(co);
        jo.setCompany(codb);
        codb.getJobOffersList().add(jo);
        cc.updateCompany(codb);
    }

    public Company createCompany(String s, String st) {
        Company co = new Company(s);
        cc.createCompany(co);
        return co;
    }

    public boolean login(Company co) {

        Company dbCompany = cc.login(co);
        if (dbCompany != null) {
            if (co.getEmail().equals(dbCompany.getEmail()) && co.getPassword().equals(dbCompany.getPassword())) {

                return true;
            }
        }
        return false;
    }

    public String printJobOffers(Company co) {
        Company codb = cc.login(co);
        String informacion = "";
        List<Object[]> jobOfferCompany = cc.getJobOffers(codb);

        for (Object[] objects : jobOfferCompany) {
            String nombrePuesto = (String) objects[0];
            int n = (Integer) objects[1];
            String direccion = (String) objects[2];
            String dellate = (String) objects[3];
            long id = (Long) objects[4];

            informacion += ("ID: " + id + "\n");
            informacion += ("Puesto de: " + nombrePuesto + "\n");
            informacion += ("Número de vacantes: " + n + "\n");
            informacion += ("Localidad del puesto: " + direccion + "\n");
            informacion += ("Detalles del puesto: " + dellate + "\n\n");

        }

        return informacion;
    }

    public String printCandidatesC(Company co, JobOffer jo) {
        String informacion = "";
        List<Candidature> l = cc.getCandidaturesByJobOffer(co, jo);
        for (Candidature candidature : l) {
            informacion+=candidature.toString();
        }
        return informacion;
    }
}
