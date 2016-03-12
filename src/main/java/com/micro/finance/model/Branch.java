package com.micro.finance.model;

import javax.persistence.*;
import java.lang.annotation.Target;
import java.util.Date;
import java.util.List;

/**
 * Created by ssvh on 3/4/16.
 */
@Entity
@Table(name="Branch")
public class Branch {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="address")
    private String address;

    @Column(name="telNo")
    private int telNo;

    @Column(name="code")
    private String code;

    @Temporal(TemporalType.TIMESTAMP)
    private Date addedDate = new Date();


    public List getFieldOfficerList() {
        return fieldOfficerList;
    }

    public void setFieldOfficerList(List fieldOfficerList) {
        this.fieldOfficerList = fieldOfficerList;
    }

    @OneToMany(targetEntity = Branch.class)
    private List fieldOfficerList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getTelNo() {
        return telNo;
    }

    public void setTelNo(int telNo) {
        this.telNo = telNo;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Column(name = "addedDate", insertable = true, updatable = false)
    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    @PrePersist
    protected void onCreate() {
        this.addedDate = new Date();
    }
}