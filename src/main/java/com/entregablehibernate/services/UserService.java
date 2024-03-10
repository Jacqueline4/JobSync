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
import java.time.LocalDate;
import java.util.List;
import org.checkerframework.checker.units.qual.A;

/**
 *
 * @author jacqueline
 */
public class UserService {

    UserController uc = new UserController();

    public void addSkill(User u, String s) {
        User udb = uc.login(u);
        Skill sk = new Skill();
        sk.setName(s);
        sk.getUserList().add(udb);
        udb.getSkillsList().add(sk);
        uc.updateUser(udb);
    }

    public void printUserInfo(User u) {
        System.out.println(u);
    }

    public void addAcademicInfo(User u, AcademicInfo ai) {
        User udb = uc.login(u);
        ai.setUser(udb);
        udb.getAcademicList().add(ai);
        uc.updateUser(udb);
    }

    public void addCandidature(User u, Candidature c) {
        User udb = uc.login(u);
        udb.getCandidaturesList().add(c);
        uc.updateUser(udb);
    }

    public void addCandidature(User u, Candidature c, JobOffer jo) {
        User udb = uc.login(u);
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
        User udb = uc.login(u);
        le.setUser(udb);
        le.setCompany(le.getCompany());
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
        User udb = uc.login(u);
        ai.setInstitution(i);
        i.getAcademicList().add(ai);
        udb.getAcademicList().add(ai);
        uc.updateUser(udb);
    }

    public void addCandidature(User u, JobOffer jo, String s, String st) {//REVISAR
        User udb = uc.login(u);
        Candidature c = new Candidature();
        c.setConverLetterPath(st);
        c.setCvPath(st);
        jo.getCandidaturesList().add(c);

        uc.updateUser(udb);
    }

    public void addCandidature(User u, JobOffer jo) {
        User udb = uc.login(u);
        Candidature c = new Candidature();
        c.setJobOffer(jo);
        udb.getCandidaturesList().add(c);
        uc.updateUser(udb);
    }

    public void removeUser(User u) {
        User udb = uc.login(u);
        uc.removeUser(udb);
    }

    public void updateUser(User u) {
        User udb = uc.login(u);
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

    public String printLaboralExp(User u) {
        List<Object[]> experienciaLabUser = uc.getLaboralE(u);
        String informacion = "";
        for (Object[] objects : experienciaLabUser) {
            String nombreEmpresa = (String) objects[0];
            String puesto = (String) objects[1];
            LocalDate fechaInicio = (LocalDate) objects[2];
            LocalDate fechaFin = (LocalDate) objects[3];
            String desc = (String) objects[4];

            informacion += ("Razón social: " + nombreEmpresa + "\n");
            informacion += ("Periodo: " + fechaInicio + " - " + fechaFin + "\n");
            informacion += ("Puesto: " + puesto + "\n");
            informacion += ("Descripción: " + desc + "\n\n");

        }
        return informacion;
    }

    public String printAcademic(User u) {
        List<Object[]> experienciaLabUser = uc.getAcademicIn(u);
        String informacion = "";
        for (Object[] objects : experienciaLabUser) {
            String nombreInstitucion = (String) objects[0];
            String titulo = (String) objects[1];
            LocalDate fechaInicio = (LocalDate) objects[2];
            LocalDate fechaFin = (LocalDate) objects[3];
            Float desc = (Float) objects[4];

            informacion += ("Centro de Estudio: " + nombreInstitucion + "\n");
            informacion += ("Periodo: " + fechaInicio + " - " + fechaFin + "\n");
            informacion += ("Título: " + titulo + "\n");
            informacion += ("Puntuación: " + desc + "\n\n");

        }
        return informacion;
    }

    public String printSkills(User u) {
        List<Skill> skillList = uc.getUserSkills(u);
        String informacion = "";
        for (Skill skill : skillList) {
            informacion += skill + "\t";
        }
        return informacion;
    }

    public String printCandidatures(User u) {
        List<Object[]> experienciaLabUser = uc.getCandida(u);
        String informacion = "";
        for (Object[] objects : experienciaLabUser) {
            String nombreEmpresa = (String) objects[0];
            String puesto = (String) objects[1];
            Integer minSalary = (Integer) objects[2];
            Integer maxSalary = (Integer) objects[3];
            String dir = (String) objects[4];

            informacion += ("Razón social: " + nombreEmpresa + "\n");
            informacion += ("Rango salarial: " + minSalary + " - " + maxSalary + "\n");
            informacion += ("Puesto: " + puesto + "\n");
            informacion += ("Dirección: " + dir + "\n\n");

        }
        return informacion;
    }
}
