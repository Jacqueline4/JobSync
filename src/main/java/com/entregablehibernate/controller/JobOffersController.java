/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.entregablehibernate.controller;

import com.entregablehibernate.dao.JobOffersDAO;
import com.entregablehibernate.model.Candidature;
import com.entregablehibernate.model.Company;
import com.entregablehibernate.model.JobOffer;
import com.entregablehibernate.model.Skill;
import com.entregablehibernate.model.User;
import com.entregablehibernate.utils.*;
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
public class JobOffersController implements JobOffersDAO {

    @Override
    public void removeJobOffer(JobOffer jo) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getFactory().openSession()) {
            tx = session.beginTransaction();
            if (jo.getId() != 0) {
                session.remove(jo);
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
    public void updateJobOffer(JobOffer jo) {

        Transaction tx = null;
        try (Session session = HibernateUtil.getFactory().openSession()) {
            tx = session.beginTransaction();
            if (jo.getId() != 0) {
                session.merge(jo);
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
    public List<JobOffer> getJobOfferBySalary(int salary) {
        try (Session session = HibernateUtil.getFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<JobOffer> query = cb.createQuery(JobOffer.class);
            Root<JobOffer> jobOffTable = query.from(JobOffer.class);
            query.where(cb.greaterThan(jobOffTable.get("minSalary"), salary));
            return session.createQuery(query).getResultList();
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }

    @Override
    public List<JobOffer> getJobOfferByTitle(String title) {
        try (Session session = HibernateUtil.getFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<JobOffer> query = cb.createQuery(JobOffer.class);
            Root<JobOffer> jobOffTable = query.from(JobOffer.class);
            query.where(cb.equal(jobOffTable.get("title"), title));
            return session.createQuery(query).getResultList();
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }

    }

    @Override
    public List<JobOffer> getJobOfferBySkill(String skill) {
        try (Session session = HibernateUtil.getFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<JobOffer> query = cb.createQuery(JobOffer.class);
            Root<Skill> skillTable = query.from(Skill.class);
            Join<JobOffer, Skill> jobOffTable = skillTable.join("jobOfferList");
            query.where(cb.equal(jobOffTable, skill));
            return session.createQuery(query).getResultList();
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }

    @Override
    public List<Object[]> getJobOfferCandidatures(String nombrePuesto) {
        try (Session session = HibernateUtil.getFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Object[]> query = cb.createQuery(Object[].class);
            Root<User> userTable = query.from(User.class);
            Join<User, Candidature> candidatureTable = userTable.join("candidaturesList");
            Join<Candidature, JobOffer> jobOfferTable = candidatureTable.join("jobOffer");
            Join<JobOffer, Company> companyTable = jobOfferTable.join("company");
            query.where(cb.equal(jobOfferTable.get("title"), nombrePuesto));
            query.multiselect(userTable.get("name"),
                    userTable.get("skillsList")
            );
            List info = session.createQuery(query).getResultList();
            return info;
        }

    }

    @Override
    public List<JobOffer> getJobOfferByLocation(String location) {
        try (Session session = HibernateUtil.getFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<JobOffer> query = cb.createQuery(JobOffer.class);
            Root<JobOffer> jobOffTable = query.from(JobOffer.class);
            query.where(cb.equal(jobOffTable.get("location"), location));
            return session.createQuery(query).getResultList();
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }

    @Override
    public List<JobOffer> getJobOfferBySkill(Skill skill) {
        try (Session session = HibernateUtil.getFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<JobOffer> query = cb.createQuery(JobOffer.class);
            Root<Skill> skillTable = query.from(Skill.class);
            Join<JobOffer, Skill> jobOffTable = skillTable.join("jobOfferList");
            query.where(cb.equal(skillTable, skill));
            return session.createQuery(query).getResultList();
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }

    @Override
    public List<JobOffer> getJobOffer(Long id) {
        try (Session session = HibernateUtil.getFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<JobOffer> query = cb.createQuery(JobOffer.class);
            Root<JobOffer> jobOffTable = query.from(JobOffer.class);
            query.where(cb.equal(jobOffTable, id));
            return session.createQuery(query).getResultList();
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }

    public JobOffer getJobOfferById(Long id) {
        try (Session session = HibernateUtil.getFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<JobOffer> query = cb.createQuery(JobOffer.class);
            Root<JobOffer> jobOffTable = query.from(JobOffer.class);
            query.where(cb.equal(jobOffTable.get("id"), id));
            return session.createQuery(query).getSingleResult();
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }

    @Override//REVISAR!
    public List<JobOffer> getJobOfferByWorkDayType(WorkDayType wdt) {
        try (Session session = HibernateUtil.getFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<JobOffer> query = cb.createQuery(JobOffer.class);
            Root<JobOffer> jobOffTable = query.from(JobOffer.class);
            query.where(cb.equal(jobOffTable, wdt.getValue()));
            return session.createQuery(query).getResultList();
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }

    }

    @Override
    public void createJobOffer(JobOffer jo) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getFactory().openSession()) {
            tx = session.beginTransaction();
            session.persist(jo);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            System.err.println(e);
        }
    }

    @Override
    public List<JobOffer> getJobOfferByCompany(Company company) {
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
