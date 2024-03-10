/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.entregablehibernate.controller;

import com.entregablehibernate.dao.UsersDAO;
import com.entregablehibernate.model.AcademicInfo;
import com.entregablehibernate.model.Candidature;
import com.entregablehibernate.model.Company;
import com.entregablehibernate.model.Institution;
import com.entregablehibernate.model.LaboralExperiece;
import com.entregablehibernate.model.Skill;
import com.entregablehibernate.model.User;
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
public class UserController implements UsersDAO {

    @Override
    public void createUser(User u) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getFactory().openSession()) {
            tx = session.beginTransaction();
            session.persist(u);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            System.err.println(e);
        }
    }

    @Override
    public List<AcademicInfo> getUserAcademicInfo(User u) {
        try (Session session = HibernateUtil.getFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<AcademicInfo> query = cb.createQuery(AcademicInfo.class);
            Root<AcademicInfo> academicInfoTable = query.from(AcademicInfo.class);
            Join<AcademicInfo, User> userTable = academicInfoTable.join("user");// el de la clase de AcademicInfo
            query.where(cb.equal(userTable, u));// esta expresion cb.equal(userTable, u)
            // es la simplificacion de userTable.get("id"), u.getId())           
            return session.createQuery(query).getResultList();
        }
    }

    @Override
    public void removeUser(User u) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getFactory().openSession()) {
            tx = session.beginTransaction();
            if (u.getId() != 0) {
                session.remove(u);
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
    public User getUser(Long id) {
        try (Session session = HibernateUtil.getFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<User> query = cb.createQuery(User.class);
            Root<User> userTable = query.from(User.class);
            query.where(cb.equal(userTable, id));///
            return session.createQuery(query).getSingleResult();
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }

    @Override
    public List<Skill> getUserSkills() {
        try (Session session = HibernateUtil.getFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Skill> query = cb.createQuery(Skill.class);
            Root<Skill> skillTable = query.from(Skill.class);
            Join<Skill, User> userTable = skillTable.join("userList");
//            query.where(cb.equal(userTable, u));
            // es la simplificacion de userTable.get("id"), u.getId())           
            return session.createQuery(query).getResultList();
        }
    }

    @Override
    public List<Candidature> getUserCandidatures(User u) {
        try (Session session = HibernateUtil.getFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Candidature> query = cb.createQuery(Candidature.class);
            Root<Candidature> candidatureTable = query.from(Candidature.class);
            Join<Candidature, User> userTable = candidatureTable.join("user");
            query.where(cb.equal(userTable, u));
            return session.createQuery(query).getResultList();
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }

    @Override
    public List<User> getUsersByName(User u) {
        try (Session session = HibernateUtil.getFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<User> query = cb.createQuery(User.class);
            Root<User> userTable = query.from(User.class);
            query.select(userTable.get("name")).where(cb.like(userTable.get("name"), "%" + u.getName() + "%"));
            return session.createQuery(query).getResultList();
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }

    @Override
    public void updateUser(User u) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getFactory().openSession()) {
            tx = session.beginTransaction();
            if (u.getId() != 0) {
                session.merge(u);
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
    public List<LaboralExperiece> getUserLaboralExperieces(User u) {
        try (Session session = HibernateUtil.getFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<LaboralExperiece> query = cb.createQuery(LaboralExperiece.class);
            Root<LaboralExperiece> laboralExpTable = query.from(LaboralExperiece.class);
            Join<LaboralExperiece, User> userTable = laboralExpTable.join("user");
            query.where(cb.equal(userTable, u));
            return session.createQuery(query).getResultList();
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }

    @Override
    public User getUserByName(User u) {
        try (Session session = HibernateUtil.getFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<User> query = cb.createQuery(User.class);
            Root<User> userTable = query.from(User.class);
            query.where(cb.equal(userTable.get("name"), u.getName()));
            return session.createQuery(query).getSingleResult();
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }

    @Override
    public User login(User u) {
        try (Session session = HibernateUtil.getFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<User> query = cb.createQuery(User.class);
            Root<User> userTable = query.from(User.class);
            query.where(cb.and(cb.equal(userTable.get("mail"), u.getMail()), cb.equal(userTable.get("password"), u.getPassword())));

            return session.createQuery(query).getSingleResult();
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }
    public List<Object[]> getLaboralE() { 
        try (Session session = HibernateUtil.getFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Object[]> query = cb.createQuery(Object[].class);
            Root<User> userTable = query.from(User.class);
            Join<User, LaboralExperiece> laboralExpTable = userTable.join("laboralExpList");
            Join<LaboralExperiece, Company> companyTable = laboralExpTable.join("company");
//            query.where(cb.equal(institutionTable, le));
            query.multiselect(companyTable.get("name"),
                    laboralExpTable.get("jobTitle"),
                    laboralExpTable.get("initDate"),
                    laboralExpTable.get("endDate"),
                    laboralExpTable.get("description")
            );

            return session.createQuery(query).getResultList();
        }
    }
        public List<Object[]> getAcademicIn() { 
        try (Session session = HibernateUtil.getFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Object[]> query = cb.createQuery(Object[].class);
            Root<User> userTable = query.from(User.class);
            Join<User, AcademicInfo> academicTable = userTable.join("academicList");
            Join<AcademicInfo, Institution> institutionTable = academicTable.join("institution");
            query.multiselect(institutionTable.get("name"),
                    academicTable.get("title"),
                    academicTable.get("initDate"),
                    academicTable.get("endDate"),
                    academicTable.get("meanScore")
            );

            return session.createQuery(query).getResultList();
        }
    }
 
}
