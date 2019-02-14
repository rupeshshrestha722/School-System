package com.project.dao;

import com.project.entity.Class;

import java.util.List;

public interface ClassDAO {
    Class getClass(int id);
    Class getStudentFromClass(int id);
    List<Class> findAll();
   void removeClass(int id);
   void saveClass(Class schoolClass);
   void updateClass(Class schoolClass);


}
