package com.java1234.dao;

import com.java1234.model.DeviceRun;
import com.java1234.util.StringUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//查询设备运行
public class DeviceRunDao {
    public ResultSet list(Connection con, DeviceRun deviceRun) throws Exception {
        StringBuffer sb = new StringBuffer("SELECT dname,crname,ddate,drun FROM device_run");
        if (StringUtil.isNotEmpty(deviceRun.getDname())) {
            sb.append(" and dname=" + "'" + deviceRun.getDname()+ "'");
        }
        if (StringUtil.isNotEmpty(deviceRun.getCrname())) {
            sb.append(" and crname=" + deviceRun.getCrname());
        }
        if (StringUtil.isNotEmpty(deviceRun.getDdate())) {
            sb.append(" and ddate=" + "'" + deviceRun.getDdate() + "'");
        }

        PreparedStatement pstmt = con.prepareStatement(sb.toString().replaceFirst("and", "where"));
        return pstmt.executeQuery();
    }

    public int update(Connection con, DeviceRun deviceRun) throws Exception {
        StringBuffer sb = new StringBuffer("update device_run set ");
        sb.append(" ddate=" + "'" + deviceRun.getDdate() + "'");
        sb.append(" ,drun=" + "'" + deviceRun.getDrun() + "'");
        sb.append(" and dname=" + "'" + deviceRun.getDname() + "'");
        sb.append(" and crname=" + "'" + deviceRun.getCrname() + "'");
        PreparedStatement pstmt = con.prepareStatement(sb.toString().replaceFirst("and", "where"));

        return  pstmt.executeUpdate();

    }
    public int FixUpdate(Connection con, DeviceRun deviceRun) throws Exception {
        String sql = "UPDATE device_run  RIGHT JOIN fix_device ON device_run.dname=fix_device.name SET device_run.drun='修理中'";

        PreparedStatement pstmt = con.prepareStatement(sql);

        return  pstmt.executeUpdate();

    }
    public int ScrapUpdate(Connection con, DeviceRun deviceRun) throws Exception {
        String sql = "UPDATE device_run  RIGHT JOIN scrap ON device_run.dname=scrap.name SET device_run.drun='已报废' ";

        PreparedStatement pstmt = con.prepareStatement(sql);

        return  pstmt.executeUpdate();

    }


    public static int Add(Connection con, DeviceRun deviceRun) throws Exception {
        String sql = "insert into device_run values(null,?,?,null,null)";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, deviceRun.getDname());
        pstmt.setString(2, deviceRun.getCrname());
        return pstmt.executeUpdate();
    }

    public ResultSet Runlist(Connection con, DeviceRun deviceRun) throws Exception {
         String sql="select data from e_add where name=?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, deviceRun.getDname());
        return pstmt.executeQuery();
    }


}
