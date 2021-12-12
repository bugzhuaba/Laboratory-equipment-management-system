package com.java1234.dao;

import com.java1234.model.DeviceFix;
import com.java1234.model.DeviceRun;
import com.java1234.model.DeviceScrap;
import com.java1234.util.StringUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DeviceScrapDao {
    public static int Add(Connection con, DeviceScrap deviceScrap) throws Exception {
        String sql = "insert into scrap values(null,?,?,?)";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(2, deviceScrap.getName());
        pstmt.setString(1, deviceScrap.getScrap_date());
        pstmt.setString(3, deviceScrap.getRun());

        return pstmt.executeUpdate();
    }
    public static ResultSet UpdateRun(Connection con, DeviceRun deviceRun) throws Exception {
        String sql =  "SELECT run from scrap";
        PreparedStatement pstmt = con.prepareStatement(sql);
        return pstmt.executeQuery();
    }
    public static ResultSet roundlist(Connection con, DeviceRun deviceRun) throws Exception {
        String sql =  "SELECT dname from device_run where drun='不正常'";
        PreparedStatement pstmt = con.prepareStatement(sql);
        return pstmt.executeQuery();
    }
    public static ResultSet UpdateFix(Connection con, DeviceFix deviceFix)throws Exception{
        String sql ="select name,run from fix_device where name=?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, deviceFix.getName());
        return pstmt.executeQuery();
    }

    public ResultSet list(Connection con, DeviceScrap deviceScrap) throws Exception {
        String sql = "SELECT dname,ddate,drun from device_run where drun='不正常'";
        PreparedStatement pstmt = con.prepareStatement(sql);
        return pstmt.executeQuery();
    }

    public ResultSet scraplist(Connection con,DeviceScrap deviceScrap) throws Exception {
        StringBuffer sb = new StringBuffer("SELECT name,date,run FROM scrap");
        if (StringUtil.isNotEmpty(deviceScrap.getName())) {
            sb.append(" and name=" + "'" + deviceScrap.getName() + "'");
        }
        if (StringUtil.isNotEmpty(deviceScrap.getScrap_date())) {
            sb.append(" and date=" + "'" + deviceScrap.getScrap_date() + "'");
        }

        if (StringUtil.isNotEmpty(deviceScrap.getRun())) {
            sb.append(" and fix_factory=" + deviceScrap.getRun());
        }


        PreparedStatement pstmt = con.prepareStatement(sb.toString().replaceFirst("and", "where"));
        return pstmt.executeQuery();
    }
}
