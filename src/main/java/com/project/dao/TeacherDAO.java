package com.project.dao;

import com.project.entity.Teacher;

import java.util.List;

public interface TeacherDAO {
    void saveTeacher(Teacher teacher);
    List<Teacher> findAllTeacher();
    void removeTeacher(Teacher teacher);
    Teacher getTeacher(int id);
    void updateTeacher(Teacher teacher);

}
