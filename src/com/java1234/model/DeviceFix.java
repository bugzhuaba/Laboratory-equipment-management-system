package com.java1234.model;

public class DeviceFix {
    private int id;
    private String fix_date;
    private String name;
    private String fix_factory;
    private String fix_money;
    private String dutyer;
    private String run;


    public DeviceFix(String fix_date, String name, String fix_factory, String fix_money, String dutyer,String run) {
        this.fix_date = fix_date;
        this.name = name;
        this.fix_factory = fix_factory;
        this.dutyer = dutyer;
        this.run = run;

    }
    public DeviceFix(){
        super();
    }

    public String getRun() {
        return run;
    }

    public void setRun(String run) {
        this.run = run;
    }

    public String getDutyer() {
        return dutyer;
    }

    public void setDutyer(String dutyer) {
        this.dutyer = dutyer;
    }

    public String getFix_money() {
        return fix_money;
    }

    public void setFix_money(String fix_money) {
        this.fix_money = fix_money;
    }

    public String getFix_factory() {
        return fix_factory;
    }

    public void setFix_factory(String fix_factory) {
        this.fix_factory = fix_factory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFix_date() {
        return fix_date;
    }

    public void setFix_date(String fix_date) {
        this.fix_date = fix_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}