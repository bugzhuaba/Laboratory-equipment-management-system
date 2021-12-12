package com.java1234.view;

import com.java1234.dao.DeviceRunDao;
import com.java1234.model.DeviceRun;
import com.java1234.util.DbUtil;
import com.java1234.util.StringUtil;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;


public class DeviceRunUpdataFrm extends JFrame {

    private JPanel contentPane;
    private JTextField dnameTF;
    private JTextField yearTF;
    private JTextField monthTF;
    private JTextField dayTF;
    private JComboBox drunCB;
    private DbUtil dbUtil = new DbUtil();
    private DeviceRunDao deviceRunDao = new DeviceRunDao();
    private JTextField crnameTF;


    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    DeviceRunUpdataFrm frame = new DeviceRunUpdataFrm();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public DeviceRunUpdataFrm() {
        setTitle("\u4FEE\u6539\u8BBE\u5907\u8FD0\u884C\u754C\u9762");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 845, 522);
        contentPane = new JPanel();
        contentPane.setBackground(Color.PINK);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JLabel lblNewLabel = new JLabel("\u8BF7\u8F93\u5165\u4F60\u60F3\u4FEE\u6539\u7684\u8BBE\u5907\u540D\u79F0:");
        lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 24));

        dnameTF = new JTextField();
        dnameTF.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("\u8F93\u5165\u4FEE\u6539\u65E5\u671F\uFF1A");
        lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 24));

        yearTF = new JTextField();
        yearTF.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("\u5E74");
        lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 24));

        monthTF = new JTextField();
        monthTF.setColumns(10);

        JLabel lblNewLabel_2_1 = new JLabel("\u6708");
        lblNewLabel_2_1.setFont(new Font("宋体", Font.PLAIN, 24));

        dayTF = new JTextField();
        dayTF.setColumns(10);

        JLabel lblNewLabel_2_1_1 = new JLabel("\u65E5");
        lblNewLabel_2_1_1.setFont(new Font("宋体", Font.PLAIN, 24));

        drunCB = new JComboBox();
        drunCB.setSize(100,20);
        drunCB.setBackground(new Color(255, 245, 238));
        drunCB.addItem("正常");
        drunCB.addItem("不正常");




        JLabel lblNewLabel_1_1 = new JLabel("\u4FEE\u6539\u8FD0\u884C\u72B6\u51B5\uFF1A");
        lblNewLabel_1_1.setFont(new Font("宋体", Font.PLAIN, 24));

        JButton btnNewButton = new JButton("\u8FD4\u56DE\u67E5\u8BE2\u8FD0\u884C\u72B6\u51B5");
        btnNewButton.setFont(new Font("宋体", Font.PLAIN, 18));
        btnNewButton.setBackground(new Color(255, 245, 238));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ToSelectFrmActionPerformed(e);
            }
        });

        JButton btnNewButton_1 = new JButton("\u8FD4\u56DE\u4E3B\u754C\u9762");
        btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 18));
        btnNewButton_1.setBackground(new Color(255, 245, 238));
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ToMainActionPerformed();
            }
        });

        JButton saveBT = new JButton("\u4FDD\u5B58");
        saveBT.setBackground(new Color(255, 245, 238));
        saveBT.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                UpdateActionPerformed(e);
            }
        });

        JLabel lblNewLabel_3 = new JLabel("\u8BF7\u8F93\u5165\u673A\u623F\u540D\u79F0\uFF1A");
        lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 24));

        crnameTF = new JTextField();
        crnameTF.setColumns(10);

        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGap(59)
                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                                .addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 311, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                .addComponent(dnameTF, GroupLayout.PREFERRED_SIZE, 252, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                                                .addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                                                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                                                .addComponent(yearTF, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(18)
                                                                                .addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                                                .addComponent(monthTF, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(ComponentPlacement.RELATED))
                                                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                                                .addComponent(lblNewLabel_1_1)
                                                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                                                .addComponent(drunCB, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(145)))
                                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                                                .addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                                                .addComponent(dayTF, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(10)
                                                                                .addComponent(lblNewLabel_2_1_1, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE))
                                                                        .addComponent(saveBT, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE))
                                                                .addGap(109))
                                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                                .addComponent(lblNewLabel_3)
                                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                                .addComponent(crnameTF, GroupLayout.PREFERRED_SIZE, 252, GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGap(83)
                                                .addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE)
                                                .addGap(155)
                                                .addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(55)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(dnameTF, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
                                .addGap(18)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(crnameTF, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
                                .addGap(2)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGap(30)
                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                                .addGap(7)
                                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                                        .addComponent(lblNewLabel_2)
                                                                        .addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)))
                                                        .addComponent(monthTF, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
                                                                .addComponent(lblNewLabel_2_1_1, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(dayTF, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGap(18)
                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                        .addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(yearTF, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))))
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGap(37)
                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                        .addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(drunCB, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGap(58)
                                                .addComponent(saveBT, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)))
                                .addGap(73)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
                                .addGap(64))
        );
        contentPane.setLayout(gl_contentPane);
        this.setLocationRelativeTo(null);
    }

    private void UpdateActionPerformed(ActionEvent evt) {
        String dname=this.dnameTF.getText();
        String dyear = this.yearTF.getText();
        String dmonth = this.monthTF.getText();
        String dday = this.dayTF.getText();
        String ddate=null;
        String crname =this.crnameTF.getText();
        String drun= (String) this.drunCB.getSelectedItem();
        if((StringUtil.isNotEmpty(dyear))&&(StringUtil.isNotEmpty(dmonth))&&(StringUtil.isNotEmpty(dday))){
            ddate=dyear + "-" + dmonth + "-" + dday;
        }

        if(StringUtil.isEmpty(crname)){
            JOptionPane.showMessageDialog(null,"设备名和机房名称不能为空");
            return;

        }
        if(StringUtil.isEmpty(dname)){
            JOptionPane.showMessageDialog(null,"设备名和机房名称不能为空");
            return;
        }
        if((StringUtil.isEmpty(dyear))||(StringUtil.isEmpty(dmonth))||(StringUtil.isEmpty(dday))){
            JOptionPane.showMessageDialog(null,"日期为空");
            return;
        }

        DeviceRun deviceRun=new DeviceRun(dname,crname,ddate,drun);
        Connection con=null;
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        try {
            con = dbUtil.getCon();
            String sql="select data from e_add where name=?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1,dname);
            ResultSet rs = pstmt.executeQuery();;
            String v;
            while (rs.next()) {

                v=rs.getString(1);
                if(dateFormat.parse(ddate).getTime()<dateFormat.parse(v).getTime()) {
                    JOptionPane.showMessageDialog(null,"日期错误！");
                        return;
                }
            }



        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                dbUtil.closeCon(con);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        try {
            con=dbUtil.getCon();
            int n= deviceRunDao.update(con,deviceRun);
            if(n==1){
                JOptionPane.showMessageDialog(null,"修改成功！");
                resetValue();
            }else{
                JOptionPane.showMessageDialog(null,"修改失败！");
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"修改失败！");
        } finally {
            try {
                dbUtil.closeCon(con);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    private void resetValue() {
        this.dnameTF.setText("");
        this.yearTF.setText("");
        this.monthTF.setText("");
        this.dayTF.setText("");
        this.crnameTF.setText("");

    }




    private void ToSelectFrmActionPerformed(ActionEvent e) {
        dispose();
        new DeviceRunSelectFrm().setVisible(true);
    }


    private void ToMainActionPerformed() {
        dispose();
        new MainFrm().setVisible(true);
    }


}

