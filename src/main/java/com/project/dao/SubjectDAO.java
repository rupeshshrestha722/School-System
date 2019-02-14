package com.project.dao;

import com.project.entity.Subject;

import java.util.List;

public interface SubjectDAO {

     Subject getSubject(Integer id);
    List<Subject> getSubjectsFromClass(int classID);
     void saveSubject(Subject subject);
     List<Subject> findAll();
     void removeSubject(Subject subject);
    void updateSubject(Subject subject);
}
