/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.entregablehibernate.utils;

import com.entregablehibernate.model.AcademicInfo;
import com.entregablehibernate.model.Company;
import com.entregablehibernate.model.Institution;
import com.entregablehibernate.model.JobOffer;
import com.entregablehibernate.model.LaboralExperiece;
import com.entregablehibernate.model.Skill;
import com.entregablehibernate.model.User;
import com.entregablehibernate.services.CompanyService;
import com.entregablehibernate.services.JobOffersService;
import com.entregablehibernate.services.UserService;
import java.time.LocalDate;

/**
 *
 * @author jacqueline
 */
public class mainRaul {
    
    static CompanyService companyService = new CompanyService();
    static  JobOffersService jobOfferService = new JobOffersService();
    static UserService userService = new UserService();

    public static void main(String[] args) {

        // User  FUNCIONA
        User raul = new User("Raul", 6565, "Chico", "raul");
        userService.createUser(raul);
        raul.setPassword("klk");
        //userService.removeUser(raul);


//        Agregando Habilidades y Educación
        Skill buenProgramador = new Skill("programación");
        userService.addSkill(raul, buenProgramador);
        Institution europa = new Institution("Europa");
        AcademicInfo infoRaul = new AcademicInfo(raul, europa);
        LocalDate fecha = LocalDate.of(2023, 2, 7);
        LocalDate fechaFin = LocalDate.of(2024, 2, 7);
        infoRaul.setInitDate(fecha);
        infoRaul.setEndDate(fechaFin);
        infoRaul.setMeanScore((float) 8.7);
        infoRaul.setTitle("DAM");
        userService.addAcademicInfo(raul, infoRaul, europa);

        //COMPANY Y OFFER FUNCIONA
        Company accenture = new Company("Accenture", "explotadol");
        companyService.createCompany(accenture);
//        accenture.setPassword("klkCompany");
        JobOffer offer = new JobOffer("programador", accenture);
        jobOfferService.createJobOffer(offer);
//        jobOfferService.addSkillJobOffer(offer,buenProgramador);
        offer.setMaxSalary(40000);
        offer.setMinSalary(30000);
        offer.setOpen(true);
        offer.setRequiredCandidates(10);
        offer.setWorkDayType(WorkDayType.PART_TIME); //CONTRACT
        offer.setDetails("Trabajar mucho");
        offer.setLocation("Madrid");

        // Aplicando a una Oferta de Trabajo
        userService.addCandidature(raul,offer,"klkCurriculum","CartaKlk");

        // Experiencia Laboral
        LaboralExperiece raulExperiencia = new LaboralExperiece(accenture, raul);
        raulExperiencia.setDescription("Extensa experiencia");
//        raulExperiencia.setJob_title("DAM");
        raulExperiencia.setLocation("Madrid");
        raulExperiencia.setCurrent(true);
//        raulExperiencia.setInit_date(fecha);
//        raulExperiencia.setEnd_date(fechaFin);
        userService.addLaboralExperience(raul, raulExperiencia);
    }
}

