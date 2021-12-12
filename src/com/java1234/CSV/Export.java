package com.java1234.CSV;


import com.java1234.dao.DeviceTypeDao;
import com.java1234.model.DeviceType;

import javax.swing.*;
import java.io.File;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Export {
    public void exportToCsv_Student() throws SQLException {
        JFileChooser jf = new JFileChooser();
        jf.setFileSelectionMode(JFileChooser.SAVE_DIALOG
                | JFileChooser.DIRECTORIES_ONLY);
        // 弹出具有自定义 approve 按钮的自定义文件选择器对话框。
        jf.showDialog(null, null);
        File file = jf.getSelectedFile();
        String path = ((File) file).getAbsolutePath();// 取得绝对路径

        // 取得当前时间，格式是yyyyMMddHHmmss
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String date_str = sdf.format(new Date());

        // 拼接导出文件的路径
        // 路径：绝对路径+"采购列表"+"yyyyMMddHHmmss"
        path = path + "\\设备信息" + date_str + ".csv";
        System.out.println("csv导出路径：" + path);


        // 获取数据
        //Connection con=null;
        DeviceTypeDao deviceTypeDao = new DeviceTypeDao();
        List<DeviceType> allDevices = deviceTypeDao.selectAll();

        // 获取csv表头
        String[] names = { "设备名称", "设备类型", "设备型号", "设备规格", "设备单价", "机房名称","入库批次" };

        File f = CSVUtil.createCSVFileOfStudent(names, allDevices, path);
        if (f != null) {
            JOptionPane.showMessageDialog(null, "恭喜，文件导出完毕！", "提示", JOptionPane.INFORMATION_MESSAGE);
            //            Message.getMsg("恭喜，文件导出完毕！", "提示消息");
        }
    }
}