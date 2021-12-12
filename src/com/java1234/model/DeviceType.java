package com.java1234.model;

//设备类别实体
public class DeviceType {

    private int id;
    private String type;
    private String name;
    private String model;
    private String spec;
    private String money;
    private String num;
    private String data;
    private String factory;
    private String buyer;
    private String batch;
    private String crname;


    public DeviceType(String type,String name,String model,String spec,String money,String num,String data,String factory,String buyer,String batch,String crname) {
        this.type =type;
        this.name =name;
        this.model =model;
        this.spec =spec;
        this.money =money;
        this.num =num;
        this.data =data;
        this.factory =factory;
        this.buyer =buyer;
        this.batch =batch;
        this.crname =crname;
    }
    public DeviceType(){
        super();
    }



    public String getCrname() {
        return crname;
    }

    public void setCrname(String crname) {
        this.crname= crname;
    }
    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }
    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    public String getFactory() {
        return factory;
    }

    public void setFactory(String factory) {
        this.factory = factory;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
