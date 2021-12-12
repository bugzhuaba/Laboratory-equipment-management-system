package com.java1234.dao;

import com.java1234.model.DeviceFix;
import com.java1234.model.DeviceRun;
import com.java1234.util.StringUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DeviceFixDao {
    public static int Add(Connection con, DeviceFix deviceFix) throws Exception {
        String sql = "insert into fix_device values(null,?,?,?,?,?,?)";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, deviceFix.getFix_date());
        pstmt.setString(2, deviceFix.getName());
        pstmt.setString(3, deviceFix.getFix_factory());
        pstmt.setString(4, deviceFix.getFix_money());
        pstmt.setString(5, deviceFix.getDutyer());
        pstmt.setString(6, deviceFix.getRun());

        return pstmt.executeUpdate();
    }

    public static ResultSet UpdateRun(Connection con, DeviceRun deviceRun) throws Exception {
        String sql =  "SELECT run from fix_device";
        PreparedStatement pstmt = con.prepareStatement(sql);
        return pstmt.executeQuery();
    }

    public static ResultSet roundlist(Connection con, DeviceRun deviceRun) throws Exception {
        String sql =  "SELECT dname from device_run where drun='不正常'";
        PreparedStatement pstmt = con.prepareStatement(sql);
        return pstmt.executeQuery();
    }

    public ResultSet list(Connection con, DeviceFix deviceFix) throws Exception {
        String sql = "SELECT dname,ddate,drun from device_run where drun='不正常'";
        PreparedStatement pstmt = con.prepareStatement(sql);
        return pstmt.executeQuery();
    }
    public ResultSet Fixlist(Connection con,DeviceFix deviceFix) throws Exception {
        StringBuffer sb = new StringBuffer("SELECT fix_date,name,fix_factory,run FROM fix_device");
        if (StringUtil.isNotEmpty(deviceFix.getFix_date())) {
            sb.append(" and fix_date=" + "'" + deviceFix.getFix_date() + "'");
        }
        if (StringUtil.isNotEmpty(deviceFix.getName())) {
            sb.append(" and name=" + "'" + deviceFix.getName() + "'");
        }
        if (StringUtil.isNotEmpty(deviceFix.getFix_factory())) {
            sb.append(" and fix_factory=" + deviceFix.getFix_factory());
        }


        PreparedStatement pstmt = con.prepareStatement(sb.toString().replaceFirst("and", "where"));
        return pstmt.executeQuery();
    }
}
