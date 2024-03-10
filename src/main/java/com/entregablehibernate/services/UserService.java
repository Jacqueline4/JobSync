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



    public void addSkill(User u, String s) {
//        User udb = uc.getUserByName(u);
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
        User udb = uc.getUserByName(u);
        ai.setUser(udb);
        udb.getAcademicList().add(ai);
        uc.updateUser(udb);
    }

    public void addCandidature(User u, Candidature c) {
//        User udb = uc.getUserByName(u);
        u.getCandidaturesList().add(c);
        uc.updateUser(u);
    }

    public void addCandidature(User u, Candidature c, JobOffer jo) {
        User udb = uc.getUserByName(u);
        c.setJobOffer(jo);
        jo.getCandidaturesList().add(c);
        udb.getCandidaturesList().add(c);
        uc.updateUser(udb);
    }

    public void addSkill(User u, Skill s) {//NO..
// User udb = uc.getUserByName(u);
        s.getUserList().add(u);
        u.getSkillsList().add(s);
        uc.updateUser(u);
    }
    public void addLaboralExperience(User u, LaboralExperiece le) {//si funciona
        User udb = uc.getUserByName(u);
        le.setUser(udb);
        udb.getLaboralExpList().add(le);
        uc.updateUser(udb);
    }
//        public void addJobExperience(User u, LaboralExperiece le, Company co) {
//
//        User udb = uc.getUserByName(u);
//        le.setCompany(co);
//        co.getLaboralExperieceList().add(le);
//        udb.getLaboralExpList().add(le);
//        uc.updateUser(udb);
//    }

    public void addAcademicInfo(User u, AcademicInfo ai, Institution i) {
        User udb = uc.getUserByName(u);
        ai.setInstitution(i);
        i.getAcademicList().add(ai);
        udb.getAcademicList().add(ai);

        uc.updateUser(udb);
    }

    public void addCandidature(User u, JobOffer jo, String s, String st) {//REVISAR
        User udb = uc.getUserByName(u);
        Candidature c = new Candidature();
        c.setConverLetterPath(st);
        c.setCvPath(st);
        jo.getCandidaturesList().add(c);

        uc.updateUser(udb);
    }

    public void addCandidature(User u, JobOffer jo) {
        User udb = uc.getUserByName(u);
        Candidature c = new Candidature();
        c.setJobOffer(jo);
        udb.getCandidaturesList().add(c);
 uc.updateUser(udb);
    }

    public void removeUser(User u) {
         User udb = uc.getUserByName(u);
        uc.removeUser(udb);
    }

    public void updateUser(User u) {
         User udb = uc.getUserByName(u);
        uc.updateUser(udb);
    }

    public void createUser(User u) {

        uc.createUser(u);
    }

    public User createUser(String name, String description, int telephone, String mail) {

        User u = new User(name, description, telephone, mail);
        return u;
    }

    public boolean login(User u) {

        User dbUser = uc.login(u);
        if (dbUser != null) {
            if (u.getMail().equals(dbUser.getMail()) && u.getPassword().equals(dbUser.getPassword())) {

                return true;
            }
        }
        return false;
    }

}
