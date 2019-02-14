package com.project.entity;

import javax.persistence.*;

@Entity
@Table(name="subject")
public class Subject {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @OneToOne
    @JoinColumn(name="class")

    private Class subClass;
    @OneToOne
    @JoinColumn(name="teacher")
    private Teacher teacher;


    public Teacher getTeacher() {
        return teacher;
    }
    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Class getSubClass() {
        return subClass;
    }
    public void setSubClass(Class subClass) {
        this.subClass = subClass;
    }


}
