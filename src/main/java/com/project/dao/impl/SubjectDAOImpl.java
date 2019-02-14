package com.project.dao.impl;

import com.project.dao.SubjectDAO;
import com.project.entity.Subject;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


public class SubjectDAOImpl implements SubjectDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public Subject getSubject(Integer id) {
        Session session =sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Subject s where s.id = :id");
        query.setInteger("id", id);
        List<Subject> subjectList = new ArrayList<>();
        subjectList = query.list();
        if (subjectList.size() > 0)
            return subjectList.get(0);

        return null;
    }

    @Override
    @Transactional
    public List<Subject> getSubjectsFromClass(int classID) {

        Session session =sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Subject s where s.subClass = :subClass");
        query.setInteger("subClass", classID);

        List<Subject> subjects = new ArrayList<Subject>();
        subjects = query.list();

        return subjects;
    }

    @Override
    @Transactional
    public void saveSubject(Subject subject) {
        Session session = sessionFactory.getCurrentSession();
        session.save(subject);
    }

    @Override
    @Transactional
    public List<Subject> findAll() {
        Session session =sessionFactory.getCurrentSession();
        List<Subject> subjects = session.createQuery("from Subject").list();
        return subjects;
    }

    @Override
    @Transactional
    public void removeSubject(Subject subject) {
        Session session =sessionFactory.getCurrentSession();
        session.delete(subject);
    }

    @Override
    @Transactional
    public void updateSubject(Subject subject) {
        Session session =sessionFactory.getCurrentSession();
        session.update(subject);
    }
}
