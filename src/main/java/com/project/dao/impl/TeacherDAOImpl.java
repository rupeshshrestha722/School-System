package com.project.dao.impl;

import com.project.dao.TeacherDAO;
import com.project.entity.Class;
import com.project.entity.Teacher;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;



public class TeacherDAOImpl implements TeacherDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public void saveTeacher(Teacher teacher) {
        Session session = sessionFactory.getCurrentSession();
        Class schoolClass = teacher.getSchoolClass();
        if (schoolClass != null) {
            Teacher oldTeacher = schoolClass.getTeacher();
            if (oldTeacher != null && oldTeacher != teacher) {
                oldTeacher.setSchoolClass(null);
                session.update(oldTeacher);
            }
        } else {
            session.save(teacher);
        }
    }

    @Override
    @Transactional
    public List<Teacher> findAllTeacher() {
        Session session = sessionFactory.getCurrentSession();
        List<Teacher> teachers = session.createQuery("from Teacher").list();
        return teachers;
    }

    @Override
    @Transactional
    public void removeTeacher(Teacher teacher) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(teacher);
    }

    @Override
    @Transactional
    public Teacher getTeacher(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Teacher t where t.id = :id");
        query.setInteger("id", id);
        List<Teacher> teacherList = new ArrayList<>();
        teacherList = query.list();
        if (teacherList.size() > 0)
            return teacherList.get(0);

        return null;
    }

    @Override
    @Transactional
    public void updateTeacher(Teacher teacher) {
        Session session = sessionFactory.getCurrentSession();

        Class schoolClass = teacher.getSchoolClass();
        if (schoolClass != null) {
            Teacher oldTeacher = schoolClass.getTeacher();
            if (oldTeacher != null && oldTeacher != teacher) {
                oldTeacher.setSchoolClass(null);
                session.update(oldTeacher);
            }
        }
        session.update(teacher);
    }
}
