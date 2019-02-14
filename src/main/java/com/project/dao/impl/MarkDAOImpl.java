package com.project.dao.impl;

import com.project.dao.MarkDAO;
import com.project.entity.Mark;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public class MarkDAOImpl implements MarkDAO {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    @Transactional
    public Mark getMark(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Mark m where m.id = :id");
        query.setInteger("id", id);
        List<Mark> marks = query.list();
        if(marks.get(0)!= null)
            return marks.get(0);
        else return null;
    }

    @Override
    @Transactional
    public List<Mark> getStudentMarks(int studentId, int subjectId) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Mark m where m.student = :student and m.subject = :subject");
        query.setInteger("student", studentId);
        query.setInteger("subject", subjectId);
        List<Mark> marks = query.list();
        return marks;
    }

    @Override
    @Transactional
    public void saveMark(Mark mark) {
        Session session = sessionFactory.getCurrentSession();
        session.save(mark);
    }

    @Override
    @Transactional
    public void deleteMark(Mark mark) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(mark);
    }

    @Override
    @Transactional
    public void updateMark(Mark mark) {
        Session session = sessionFactory.getCurrentSession();
        session.update(mark);
    }
}
