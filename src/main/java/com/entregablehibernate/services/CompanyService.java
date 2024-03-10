/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.entregablehibernate.services;

import com.entregablehibernate.controller.CompanyController;
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
//        Company codb = cc.login(co);
        String informacion = "";
        if (cc.getJobOffers(co) != null) {
            List<JobOffer> joList = cc.getJobOffers(co);
            for (JobOffer jo : joList) {
                informacion += jo.toString();
            }
        }
        return informacion;
    }
}
