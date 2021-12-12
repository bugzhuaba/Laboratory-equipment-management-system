package com.java1234.model;

public class DeviceScrap {
    private int id;
    private String name;
    private String scrap_date;
    private String run;

    public DeviceScrap(String name, String scrap_date,String run) {
        this.name = name;
        this.scrap_date = scrap_date;
        this.run = run;

    }
    public DeviceScrap(){
        super();
    }

    public String getRun() {
        return run;
    }

    public void setRun(String run) {
        this.run = run;
    }

    public String getScrap_date() {
        return scrap_date;
    }

    public void setScrap_date(String scrap_date) {
        this.scrap_date = scrap_date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
