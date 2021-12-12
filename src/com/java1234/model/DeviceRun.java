package com.java1234.model;

public class DeviceRun {
    private int id;
    private String dname;
    private String crname;
    private String ddate;
    private String drun;

    public DeviceRun(String dname,String crname,String ddate,String drun) {
        this.dname = dname;
        this.crname = crname;
        this.ddate = ddate;
        this.drun = drun;
    }
    public DeviceRun(){
        super();
    }

    public String getDrun() {
        return drun;
    }

    public void setDrun(String Drun) {
        this.drun = drun;
    }

    public String getDdate() {
        return ddate;
    }

    public void setDdate(String date) {
        this.ddate = ddate;
    }

    public String getCrname() {
        return crname;
    }

    public void setCrname(String crname) {
        this.crname = crname;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
