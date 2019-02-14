package com.project.dao.impl;

import com.project.dao.StudentDAO;
import com.project.entity.Student;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


public class StudentDAOImpl implements StudentDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public void saveStudent(Student student) {
        Session session = sessionFactory.getCurrentSession();
        session.save(student);

    }

    @Override
    @Transactional
    public List<Student> findAll() {
        Session session = sessionFactory.getCurrentSession();
        List<Student> students = session.createQuery("from Student").list();
        return students;
    }

    @Override
    @Transactional
    public List<Student> getStudentsFromClass(int classId) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Student s where s.studentClass :=id");
        query.setInteger("id", classId);
        List<Student> students = query.list();
        return students;
    }

    @Override
    @Transactional
    public void removeStudent(Student student) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(student);

    }

    @Override
    @Transactional
    public Student getStudent(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Student s where s.id = :id");
        query.setInteger("id", id);
        List<Student> studentList = new ArrayList<>();
        studentList = query.list();
        if (studentList.size() > 0)
            return studentList.get(0);

        return null;
    }

    @Override
    @Transactional
    public void updateStudent(Student student) {
        Session session = sessionFactory.getCurrentSession();
        session.update(student);
    }
}
