/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.entregablehibernate.dao;

import com.entregablehibernate.model.AcademicInfo;
import com.entregablehibernate.model.Candidature;
import com.entregablehibernate.model.LaboralExperiece;
import com.entregablehibernate.model.Skill;
import com.entregablehibernate.model.User;
import java.util.List;

/**
 *
 * @author jacqueline
 */
public interface UsersDAO {

    public List<AcademicInfo> getUserAcademicInfo(User u);

    public void removeUser(User u);

    public User getUser(Long id);

    public List<Skill> getUserSkills(User u);

    public List<Candidature> getUserCandidatures(User u);

    public List<User> getUsersByName(User u);

    public void updateUser(User u);

    public void createUser(User u);

    public List<LaboralExperiece> getUserLaboralExperieces(User u);

    public User getUserByName(User u);
    public boolean login(User u);
}
