package com.project.dao.impl;

import com.project.dao.RoleDAO;
import com.project.entity.Role;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

public class RoleDAOImpl implements RoleDAO {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    @Transactional
    public Role getRole(int id) {
        Session session = sessionFactory.getCurrentSession();
        Role role = (Role) session.load(Role.class, id);
        return role;
    }

    @Override
    @Transactional
    public Role getRole(String role) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Role r where r.role = :role");
        query.setParameter("role", role);
        List<Role> roleList = new ArrayList<>();
        roleList = query.list();

        if (roleList.size() > 0)
            return roleList.get(0);

        return null;
    }
}
