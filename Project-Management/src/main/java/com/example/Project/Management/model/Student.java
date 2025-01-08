package com.example.Project.Management.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.springframework.stereotype.Component;

@Entity
public class Student {

    @Id
    private int studentId;
    private String prn;
    private int name;

    public Student(int studentId, String prn, int name) {
        this.studentId = studentId;
        this.prn = prn;
        this.name = name;
    }

    public Student() {
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getPrn() {
        return prn;
    }

    public void setPrn(String prn) {
        this.prn = prn;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }
}
