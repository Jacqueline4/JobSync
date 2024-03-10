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
import com.entregablehibernate.model.User;
import com.entregablehibernate.utils.WorkDayType;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jacqueline
 */
public class JobOffersService {

    JobOffersController jc = new JobOffersController();
    JobOffer jo = new JobOffer();

    public void closeJobOffer(JobOffer jo) {
//        jc.getJobOfferByWorkDayType(WorkDayType.CONTRAC);

    }

    public void removeJobOffer(JobOffer jo) {
        jc.removeJobOffer(jo);
    }

//    public JobOffer createJobOffer(String s, Company co) {
//
//        jo.setTittle(s);
//        jo.setCompany(co);
////        jc.createJobOffer(jo);
//        return jo;
//    }

//    public List<Candidature> getCandidaturesJobOffers(JobOffer jo) {
//        List<Candidature> l = new ArrayList<>();
//        l = jc.getJobOfferCandidatures(jo);
//        return l;
//    }
    public void createJobOffer(JobOffer jo) {
        jc.createJobOffer(jo);
    }

    public String printCandidates(JobOffer jo) {
        List<Candidature> l = jc.getJobOfferCandidatures(jo);
        String informacion = "";
        for (Candidature candidature : l) {
            informacion += candidature.toString();
        }
        return informacion;
    }

//    public String printJob(String location) {
//        List<JobOffer> joList = jc.getJobOfferByLocation(location);
//        String informacion = "";
//        for (JobOffer j : joList) {
//            informacion += j + "\t";
//        }
//        return informacion;
//    }
//    public void addSkillJobOffer(JobOffer offer, Skill buenProgramador) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
}
