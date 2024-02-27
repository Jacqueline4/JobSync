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

    public void removeCompany(Company co) {
        cc.removeCompany(co);
    }

    public Company createCompany(String s) {
        Company co = new Company();
        return co;
    }

    public void printCompanyInfo(Company co) {
        System.out.println(co);
    }

    public void addJobOffer(Company co, JobOffer jo) {
        jo.setCompany(co);
        co.getJobOffersList().add(jo);
        cc.updateCompany(co);
    }

    public Company createCompany(String s, String st) {
        Company co = new Company(s);
        cc.createCompany(co);
        return co;
    }

}
