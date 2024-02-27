/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.entregablehibernate.controller;

import com.entregablehibernate.dao.CompanyDAO;
import com.entregablehibernate.model.Candidature;
import com.entregablehibernate.model.Company;
import com.entregablehibernate.model.JobOffer;
import com.entregablehibernate.utils.HibernateUtil;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Root;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author jacqueline
 */
public class CompanyController implements CompanyDAO {

    @Override
    public Company getCompanyByName(Company company) {
        try (Session session = HibernateUtil.getFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Company> query = cb.createQuery(Company.class);
            Root<Company> companyTable = query.from(Company.class);
            query.where(cb.equal(companyTable.get("name"), company.getName()));
            return session.createQuery(query).getSingleResult();
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }

    @Override
    public List<Candidature> getCandidaturesByJobOffer(Company company, JobOffer jo) {
        try (Session session = HibernateUtil.getFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Candidature> query = cb.createQuery(Candidature.class);
            Root<Candidature> candidatureTable = query.from(Candidature.class);
            Join<Candidature, JobOffer> jobOffTable = candidatureTable.join("candidaturesList");
            Join<JobOffer, Company> companyTable = jobOffTable.join("company");
            //query.where(cb.and(cb.equal(companyTabla, company),cb.equal(jobOfferTabla, job)));
            query.where(cb.and(cb.equal(jobOffTable, jo), cb.equal(companyTable, company)));
            return session.createQuery(query).getResultList();
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }

    @Override
    public void updateCompany(Company company) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getFactory().openSession()) {
            tx = session.beginTransaction();
            session.merge(company);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            System.err.println(e);
        }
    }

    @Override
    public void removeCompany(Company company) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getFactory().openSession()) {
            tx = session.beginTransaction();
            if (company.getId() != 0) {
                session.remove(company);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            System.err.println(e);
        }
    }

    @Override
    public void createCompany(Company company) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getFactory().openSession()) {
            tx = session.beginTransaction();
            session.persist(company);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            System.err.println(e);
        }
    }

    @Override
    public Company getCompany(Long id) {
        try (Session session = HibernateUtil.getFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Company> query = cb.createQuery(Company.class);
            Root<Company> companyTable = query.from(Company.class);
            query.where(cb.equal(companyTable, id));///
            return session.createQuery(query).getSingleResult();
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }

    @Override
    public List<JobOffer> getJobOffers(Company company) {
        try (Session session = HibernateUtil.getFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<JobOffer> query = cb.createQuery(JobOffer.class);
            Root<Company> companyTable = query.from(Company.class);
            Join<JobOffer, Company> jobOffTable = companyTable.join("jobOfferList");
            query.where(cb.equal(companyTable, company));
            return session.createQuery(query).getResultList();
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }

}
