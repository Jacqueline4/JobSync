/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.entregablehibernate.utils;

import com.entregablehibernate.model.AcademicInfo;
import com.entregablehibernate.model.Candidature;
import com.entregablehibernate.model.JobOffer;
import com.entregablehibernate.model.Company;
import com.entregablehibernate.model.Institution;
import com.entregablehibernate.model.LaboralExperiece;
import com.entregablehibernate.model.Skill;
import com.entregablehibernate.model.User;
import com.entregablehibernate.services.CompanyService;
import com.entregablehibernate.services.JobOffersService;
import com.entregablehibernate.services.UserService;

/**
 *
 * @author jacqueline
 */
public class Main {

    public static void main(String[] args) {
        CompanyService cs = new CompanyService();
        UserService us = new UserService();
        JobOffersService jos = new JobOffersService();
        JobOffer jo = new JobOffer();
        jo.setTittle("titleOfertat¡T");
        Company co = cs.createCompany("patata", "");
        cs.addJobOffer(co, jo);
        User u = new User("monete", "", 654214, "@dddd.com");

        AcademicInfo ai = new AcademicInfo();
        Institution i = new Institution();
        Candidature c = new Candidature(u, Status.ACCEPTED, "", "", jo);
        Candidature c1 = new Candidature(u, Status.REJECTED, "", "", jo);
        LaboralExperiece le = new LaboralExperiece();
        Skill skill = new Skill();
        skill.setName("Constante");
        le.setJobTitle("puestoPirriII");
        le.setCompany(co);
        i.setName("IES Europa");
        ai.setTitle("titulitis II");

        us.createUser(u);
        us.addAcademicInfo(u, ai);
       us.addAcademicInfo(u, ai, i);
        us.addCandidature(u, c);
        us.addCandidature(u, c1);
        us.addJobExperience(u, le, co);
        us.addLaboralExperience(u, le);
        us.addSkill(u, skill.getName());
        us.addSkill(u, skill);
//        us.removeUser(u);
//        cs.removeCompany(co);
//jos.removeJobOffer(jo);
JobOffer jo1= new JobOffer();
jo1.setTittle("oferta Nueva");
        jos.createJobOffer(jo1);

//        jos.getCandidaturesJobOffers(jo);

//        for (Candidature candidaturesJobOffer : jos.getCandidaturesJobOffers(jo)) {
//            System.out.println(candidaturesJobOffer);
//        }

    }
}
