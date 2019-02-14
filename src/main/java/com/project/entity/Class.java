package com.project.entity;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "class")
public class Class {

    @Id
    @GeneratedValue
    private long id;

    @Size(min = 2, max = 10)
    private String name;

    @Size(min = 2, max = 10)
    private String fullName;

    @NotNull
    @Min(1992)
    @Max(2018)
    private int year;

    @OneToOne(fetch = FetchType.LAZY,mappedBy = "schoolClass")
    private Teacher teacher;

    @OneToOne(fetch = FetchType.LAZY,mappedBy = "subClass")
    private Subject subject;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "studentClass")
    private List<Student> studentList;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }


    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
