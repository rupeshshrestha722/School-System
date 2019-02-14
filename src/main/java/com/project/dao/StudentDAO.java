package com.project.dao;

import com.project.entity.Student;

import java.util.List;

public interface StudentDAO {

   void saveStudent(Student student);
   List<Student> findAll();
     List<Student> getStudentsFromClass(int classId);
     void removeStudent(Student student);
     Student getStudent(int id);
     void updateStudent(Student student);

}
