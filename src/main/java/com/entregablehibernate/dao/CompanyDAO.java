/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.entregablehibernate.dao;

import com.entregablehibernate.model.Candidature;
import com.entregablehibernate.model.Company;
import com.entregablehibernate.model.JobOffer;
import java.util.List;

/**
 *
 * @author jacqueline
 */
public interface CompanyDAO {

    public Company getCompanyByName(Company company);

    public List<Candidature> getCandidaturesByJobOffer(Company company, JobOffer jo);

    public void updateCompany(Company company);

    public List<Object[]> getJobOffers(Company company);

    public void removeCompany(Company company);

    public void createCompany(Company company);

    public Company getCompany(Long id);

}
