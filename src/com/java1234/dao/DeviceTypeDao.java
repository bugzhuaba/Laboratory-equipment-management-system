package com.java1234.dao;

import com.java1234.model.DeviceType;
import com.java1234.util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//import java.awt.List;


//设备连接Dao类
public class DeviceTypeDao {
    private Connection con;
    public DeviceTypeDao() {
        try {
            con=new DbUtil().getCon();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    //设备类别添加
    public static int Add(Connection con, DeviceType deviceType) throws Exception {
        String sql = "insert into e_add values(null,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, deviceType.getType());
        pstmt.setString(2, deviceType.getName());
        pstmt.setString(3, deviceType.getModel());
        pstmt.setString(4, deviceType.getSpec());
        pstmt.setString(5, deviceType.getMoney());
        pstmt.setString(6, deviceType.getNum());
        pstmt.setString(7, deviceType.getData());
        pstmt.setString(8, deviceType.getFactory());
        pstmt.setString(9, deviceType.getBuyer());
        pstmt.setString(10, deviceType.getBatch());
        pstmt.setString(11, deviceType.getCrname());
        return pstmt.executeUpdate();
    }


    public static ResultSet batchResult(Connection con, DeviceType deviceType)throws Exception{
        StringBuffer sb = new StringBuffer("select count(name) from e_add ");
        sb.append(" and name=" + "'" + deviceType.getName() + "'");
        sb.append(" and model=" + "'" + deviceType.getModel() + "'");
        PreparedStatement pstmt = con.prepareStatement(sb.toString().replaceFirst("and", "where"));
        return pstmt.executeQuery();

    }



    //查询设备类别集合
    public  ResultSet list(Connection con, DeviceType deviceType) throws Exception {
        String sql="select * from e_add";
        PreparedStatement pstmt= con.prepareStatement(sql);
        return pstmt.executeQuery();
    }

    public List<DeviceType> selectAll() throws SQLException {

        List<DeviceType> list = new ArrayList<>();
        String sql = "select * from e_add";
        PreparedStatement ps = null;
        ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            DeviceType deviceType = new DeviceType();
            deviceType.setName(rs.getString(1));
            deviceType.setType(rs.getString(2));
            deviceType.setModel(rs.getString(3));
            deviceType.setSpec(rs.getString(4));
            deviceType.setMoney(rs.getString(5));
            deviceType.setBatch(rs.getString(7));
            deviceType.setCrname(rs.getString(6));

            list.add(deviceType);
        }
        con.close();
        return list;
    }

}