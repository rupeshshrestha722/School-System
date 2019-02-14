package com.project.dao.impl;

import com.project.dao.ClassDAO;
import com.project.entity.Class;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


public class ClassDAOImpl implements ClassDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public Class getClass(int id) {
       Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Class c where c.id = :id");
        query.setInteger("id",id);
        List<Class> classList = new ArrayList<Class>();
        classList = query.list();

        if(classList.size()>0){
            return classList.get(0);
        }else
            return  null;




    }

    @Override
    @Transactional
    public Class getStudentFromClass(int id) {
       Session session = sessionFactory.getCurrentSession();
       Query query = session.createQuery("from Class c where c.id = :id");

       query.setInteger("id",id);
       List<Class> classList = new ArrayList<Class>();
       classList = query.list();

       if(classList.size()>0){
           return  classList.get(0);
       }else{


           return null;
       }




    }

    @Override
    @Transactional
    public List<Class> findAll() {
        Session session = sessionFactory.getCurrentSession();
        List<Class> classes = session.createQuery("from Class").list();

        return classes;
    }

    @Override
    @Transactional
    public void removeClass(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Class c where c.id = :id");
        query.setInteger("id", id);
        List<Class> classList = new ArrayList<Class>();
        classList = query.list();
        if (classList.size() > 0)
            session.delete(classList.get(0));
    }

    @Override
    @Transactional
    public void saveClass(Class schoolClass) {
        Session session = sessionFactory.getCurrentSession();
        session.save(schoolClass);
    }

    @Override
    @Transactional
    public void updateClass(Class schoolClass) {
      Session session = sessionFactory.getCurrentSession();
      session.update(schoolClass);
    }
}
