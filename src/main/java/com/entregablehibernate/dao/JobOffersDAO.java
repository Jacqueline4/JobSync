/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.entregablehibernate.dao;

import com.entregablehibernate.model.JobOffer;
import com.entregablehibernate.model.*;
import com.entregablehibernate.utils.WorkDayType;
import java.util.List;

/**
 *
 * @author jacqueline
 */
public interface JobOffersDAO {

    public void removeJobOffer(JobOffer jo);

    public void updateJobOffer(JobOffer jo);

    public List<JobOffer> getJobOfferBySalary(int salary);

    public List<JobOffer> getJobOfferByTitle(String title);

    public List<JobOffer> getJobOfferBySkill(String skill);

    public List<Candidature> getJobOfferCandidatures(JobOffer jo);

    public List<JobOffer> getJobOfferByLocation(String location);

    public List<JobOffer> getJobOfferBySkill(Skill skill);

    public List<JobOffer> getJobOffer(Long id);

    public List<JobOffer> getJobOfferByWorkDayType(WorkDayType wdt);

    public void createJobOffer(JobOffer jo);

    public List<JobOffer> getJobOfferByCompany(Company company);

}
