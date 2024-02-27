/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.entregablehibernate.services;

import com.entregablehibernate.controller.UserController;
import com.entregablehibernate.model.AcademicInfo;
import com.entregablehibernate.model.Candidature;
import com.entregablehibernate.model.Company;
import com.entregablehibernate.model.Institution;
import com.entregablehibernate.model.JobOffer;
import com.entregablehibernate.model.LaboralExperiece;
import com.entregablehibernate.model.Skill;
import com.entregablehibernate.model.User;
import java.util.List;
import org.checkerframework.checker.units.qual.A;

/**
 *
 * @author jacqueline
 */
public class UserService {

    UserController uc = new UserController();

    public void addJobExperience(User u, LaboralExperiece le, Company co) {

        le.setCompany(co);
        co.getLaboralExperieceList().add(le);
        u.getLaboralExpList().add(le);
        uc.updateUser(u);
    }

    public void addSkill(User u, String s) {//no
        Skill sk = new Skill();
        sk.setName(s);
        sk.getUserList().add(u);
        u.getSkillsList().add(sk);
        uc.updateUser(u);
    }

    public void printUserInfo(User u) {
        System.out.println(u);
    }

    public void addAcademicInfo(User u, AcademicInfo ai) {
        u.getAcademicList().add(ai);
        uc.updateUser(u);
    }

    public void addCandidature(User u, Candidature c) {//SI
        u.getCandidaturesList().add(c);
        uc.updateUser(u);
    }

    public void addCandidature(User u, Candidature c, JobOffer jo) {
        c.setJobOffer(jo);
        jo.getCandidaturesList().add(c);
        u.getCandidaturesList().add(c);
        uc.updateUser(u);
    }

    public void addSkill(User u, Skill s) {//NO..
        
        s.getUserList().add(u);
        u.getSkillsList().add(s);
        uc.updateUser(u);
    }

    public void addLaboralExperience(User u, LaboralExperiece le) {//si funciona
        u.getLaboralExpList().add(le);
        uc.updateUser(u);
    }

    public void addAcademicInfo(User u, AcademicInfo ai, Institution i) {
        ai.setInstitution(i);
        i.getAcademicList().add(ai);
        u.getAcademicList().add(ai);

        uc.updateUser(u);
    }

    public void addCandidature(User u, JobOffer jo, String s, String st) {//REVISAR

        Candidature c = new Candidature();
        c.setConverLetterPath(st);
        c.setCvPath(st);
        jo.getCandidaturesList().add(c);

        uc.updateUser(u);
    }

    public void addCandidature(User u, JobOffer jo) {
        Candidature c = new Candidature();
        c.setJobOffer(jo);
        u.getCandidaturesList().add(c);
    }

    public void removeUser(User u) {
        uc.removeUser(u);
    }

    public void createUser(User u) {

        uc.createUser(u);
    }

    public User createUser(String name, String description, int telephone, String mail) {

        User u = new User(name, description, telephone, mail);
        return u;
    }
}
