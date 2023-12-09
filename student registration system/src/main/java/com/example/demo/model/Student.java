package com.example.demo.model;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class Student {
    private String name;
    private String address;

    private Date dob;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Student(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public Student(String name, String address, String dob, Long id) {
        this.name = name;
        this.address = address;
//        this.dob = dob;
        this.id = id;
    }

    public Student() {

    }

    public Student(String name, String address, String dob) throws ParseException {
        this.name = name;
        this.address = address;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        this.dob = formatter.parse(dob);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }
}
