package com.java1234.util;

import java.sql.Connection;
import java.sql.DriverManager;

//
public class DbUtil {
    private String dbUrl="jdbc:mysql://localhost:3306/exp_device?useUnicode=true&characterEncooding=utf8&useSSL=true";
    private String dbUserName="root";
    private String dbPassword="123456";
    private String jdbcName="com.mysql.cj.jdbc.Driver";//驱动名称

    public Connection getCon() throws Exception{
        Class.forName(jdbcName);
       Connection con=DriverManager.getConnection(dbUrl,dbUserName,dbPassword);
        return con;
    }

    public void closeCon(Connection con)throws Exception{
        if(con!=null){
            con.close();
        }
    }

    public static void main(String[] args) {
        DbUtil dbUtil=new DbUtil();
        try {
            dbUtil.getCon();
            System.out.println("数据库连接成功");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("数据库连接失败");
        }finally {

        }

    }

}
