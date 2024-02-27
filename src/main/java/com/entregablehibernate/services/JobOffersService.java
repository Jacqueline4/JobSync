/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.entregablehibernate.services;

import com.entregablehibernate.controller.JobOffersController;
import com.entregablehibernate.model.Candidature;
import com.entregablehibernate.model.Company;
import com.entregablehibernate.model.JobOffer;
import com.entregablehibernate.model.Skill;
import com.entregablehibernate.utils.WorkDayType;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jacqueline
 */
public class JobOffersService {

    JobOffersController jc = new JobOffersController();
    
    public void closeJobOffer(JobOffer jo) {
//        jc.getJobOfferByWorkDayType(WorkDayType.CONTRAC);

    }
    
    public void removeJobOffer(JobOffer jo) {
        jc.removeJobOffer(jo);
    }
    
    public JobOffer createJobOffer(String s, Company co) {
        JobOffer jo = new JobOffer();
        jo.setTittle(s);
        jo.setCompany(co);
//        jc.createJobOffer(jo);
        return jo;
    }
    
    public List<Candidature> getCandidaturesJobOffers(JobOffer jo) {
        List<Candidature> l = new ArrayList<>();
        l=jc.getJobOfferCandidatures(jo);
        return l;
    }
    
    public void createJobOffer(JobOffer jo) {
        jc.createJobOffer(jo);
    }

//    public void addSkillJobOffer(JobOffer offer, Skill buenProgramador) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
}
