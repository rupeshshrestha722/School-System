package com.project.dao.impl;

import com.project.dao.UserDetailsDAO;
import com.project.entity.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


public class UserDetailsDAOImpl implements UserDetailsDAO {


    @Autowired
    private SessionFactory sessionFactory;


    @Override
    @Transactional
    public User getUser(String login) {
        System.out.println("getUser");
        Session session = sessionFactory.getCurrentSession();
        System.out.println(session);
        List<User> userList = new ArrayList<User>();
        Query query = session.createQuery("from User u where u.username = :username");
        query.setParameter("username",login);
        userList = query.list();

        if(userList.size()>0){
            return  userList.get(0);
        }else


        return null;
    }

    @Transactional
    public List<User> findAll(){
        Session session = sessionFactory.getCurrentSession();
        List users = session.createQuery("frm User").list();
        return  users;
    }

    @Override
    @Transactional
    public Boolean isUserNameAvailable(String name) {
        Session session = sessionFactory.getCurrentSession();
        System.out.println(session);
        List<User> userList = new ArrayList<User>();
        Query query = session.createQuery("from User u where u.username = :username");
        query.setParameter("username",name);
        userList = query.list();

        if (userList.size() > 0)
            return false;
        else
            return true;



    }
}
