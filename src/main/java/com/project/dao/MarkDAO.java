package com.project.dao;

import com.project.entity.Mark;

import java.util.List;

public interface MarkDAO {

    Mark getMark(int id);
     List<Mark> getStudentMarks(int studentId, int subjectId);
     void saveMark(Mark mark);
    void deleteMark(Mark mark);
     void updateMark(Mark mark);
}
