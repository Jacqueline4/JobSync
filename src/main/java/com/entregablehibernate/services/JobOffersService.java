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

    public void createJobOffer(JobOffer jo) {
        jc.createJobOffer(jo);
    }

    public String printCandidates(Company co,JobOffer jo) {
        List<Object[]> userCandidates = jc.getJobOfferCandidatures(jo.getTittle());
        String informacion = "";
        for (Object[] objects : userCandidates) {
            String nombre = (String) objects[0];
            String skills = (String) objects[1];

            informacion += ("Nombre del candidato: " + nombre + "\n");           
            informacion += ("Habilidades: " + skills + "\n\n");
        }

        return informacion;
    }

}
