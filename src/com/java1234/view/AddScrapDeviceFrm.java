package com.java1234.view;

import com.java1234.dao.DeviceScrapDao;
import com.java1234.model.DeviceRun;
import com.java1234.model.DeviceScrap;
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
import java.util.Vector;

public class AddScrapDeviceFrm extends JFrame {


    private JPanel contentPane;
    private JTextField yearTF;
    private JTextField monthTF;
    private JTextField dayTF;
    private JTextField dnameTF;
    private DbUtil dbUtil = new DbUtil();
    private DeviceScrapDao deviceScrapDaoDao = new DeviceScrapDao();

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AddFixDeviceFrm frame = new AddFixDeviceFrm();
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
    public AddScrapDeviceFrm() {
        setTitle("添加报废设备界面");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 808, 479);
        contentPane = new JPanel();
        contentPane.setBackground(Color.PINK);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JLabel lblNewLabel = new JLabel("\u62A5\u5E9F\u65E5\u671F\uFF1A");
        lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));

        yearTF = new JTextField();
        yearTF.setFont(new Font("宋体", Font.PLAIN, 15));
        yearTF.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("\u5E74");
        lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 20));

        monthTF = new JTextField();
        monthTF.setFont(new Font("宋体", Font.PLAIN, 15));
        monthTF.setColumns(10);

        JLabel lblNewLabel_1_1 = new JLabel("\u6708");
        lblNewLabel_1_1.setFont(new Font("宋体", Font.PLAIN, 20));

        dayTF = new JTextField();
        dayTF.setFont(new Font("宋体", Font.PLAIN, 15));
        dayTF.setColumns(10);

        JLabel lblNewLabel_1_1_1 = new JLabel("\u65E5");
        lblNewLabel_1_1_1.setFont(new Font("宋体", Font.PLAIN, 20));

        JLabel lblNewLabel_2 = new JLabel("\u8BBE\u5907\u540D\uFF1A");
        lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 20));

        dnameTF = new JTextField();
        dnameTF.setFont(new Font("宋体", Font.PLAIN, 15));
        dnameTF.setColumns(10);

        JButton btnNewButton1 = new JButton("\u6DFB\u52A0");
        btnNewButton1.setFont(new Font("宋体", Font.PLAIN, 20));
        btnNewButton1.setBackground(new Color(255, 240, 245));
        btnNewButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    AddScrapActionPerformed(e);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });


        JButton btnNewButton2 = new JButton("\u8FD4\u56DE\u8BBE\u5907\u62A5\u5E9F\u754C\u9762");
        btnNewButton2.setFont(new Font("宋体", Font.PLAIN, 20));
        btnNewButton2.setBackground(new Color(255, 240, 245));
        btnNewButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ToMainFixFrmActionPerformed();
            }
        });

        JButton btnNewButton3 = new JButton("\u8FD4\u56DE\u4E3B\u754C\u9762");
        btnNewButton3.setFont(new Font("宋体", Font.PLAIN, 20));
        btnNewButton3.setBackground(new Color(255, 240, 245));
        btnNewButton3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ToMainFrmActionPerformed();
            }
        });
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(41)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGap(156)
                                                .addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addComponent(dnameTF, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(ComponentPlacement.RELATED, 228, Short.MAX_VALUE)
                                                .addComponent(btnNewButton1, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
                                                .addGap(89))
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addComponent(lblNewLabel)
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addComponent(yearTF, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addComponent(monthTF, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                                                .addGap(10)
                                                .addComponent(dayTF, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18)
                                                .addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(204, Short.MAX_VALUE))))
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(88)
                                .addComponent(btnNewButton2)
                                .addGap(116)
                                .addComponent(btnNewButton3, GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                                .addGap(204))
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGap(54)
                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
                                                        .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                                .addComponent(yearTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(lblNewLabel_1)
                                                                .addComponent(monthTF, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(dayTF, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(38)
                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                        .addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(dnameTF, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
                                                .addGap(125))
                                        .addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
                                                .addContainerGap(136, Short.MAX_VALUE)
                                                .addComponent(btnNewButton1, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                                                .addGap(124)))
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addComponent(btnNewButton2, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnNewButton3, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(87, Short.MAX_VALUE))
        );
        contentPane.setLayout(gl_contentPane);
        this.setLocationRelativeTo(null);
    }
    private void AddScrapActionPerformed(ActionEvent evt) throws Exception{

        String dyear = this.yearTF.getText();
        String dmonth = this.monthTF.getText();
        String dday = this.dayTF.getText();
        String name= this.dnameTF.getText();
        Connection con = null;
        String run="已报废";

        String date=null;
        if((StringUtil.isNotEmpty(dyear))&&(StringUtil.isNotEmpty(dmonth))&&(StringUtil.isNotEmpty(dday))){
            date=dyear + "-" + dmonth + "-" + dday;
        }
        DeviceScrap deviceScrap=new DeviceScrap(date,name,run);
        DeviceRun deviceRun=new DeviceRun();
        DeviceScrapDao deviceScrapDao=new DeviceScrapDao();
        con=dbUtil.getCon();
        if (StringUtil.isEmpty(name)) {
            JOptionPane.showMessageDialog(null, "设备名、日期不能为空");
            return;
        }
        if (StringUtil.isEmpty(date)) {
            JOptionPane.showMessageDialog(null, "设备名、日期不能为空");
            return;
        }
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        ResultSet rs= deviceScrapDao.roundlist(con,deviceRun);
        Vector v=new Vector();
        int flag=0;
        while (rs.next()){
            v.add(rs.getString(1));
        }  for(int i=0;i<v.size();i++) {
            if(name.equals(v.elementAt(i))){
                flag=1;
                break;
            }else{

            }

        }

        if(flag==0){

            JOptionPane.showMessageDialog(null, "设备名不存在");
            resetValue();
            return;

        }
        if (StringUtil.isEmpty(date)) {
            JOptionPane.showMessageDialog(null, "设备名和报废日期不能为空");
            return;
        }
        if (StringUtil.isEmpty(name)) {
            JOptionPane.showMessageDialog(null, "设备名和报废日期不能为空");
            return;
        }

        try {
            con = dbUtil.getCon();
            String sql="select ddate from device_run where dname=?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1,name);
            ResultSet as = pstmt.executeQuery();;
            String a;
            while (as.next()) {

                a=as.getString(1);
                if(dateFormat.parse(date).getTime()<dateFormat.parse(a).getTime()) {
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
            con = dbUtil.getCon();
            int i = DeviceScrapDao.Add(con, deviceScrap);
            if (i == 1) {
                JOptionPane.showMessageDialog(null, "报废成功！");
                resetValue();
            } else {
                JOptionPane.showMessageDialog(null, "报废失败！");
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "报废失败！");
        } finally {
            try {
                dbUtil.closeCon(con);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }


    //重置事件处理
    private void  resetValue(){
        this.yearTF.setText("");
        this.monthTF.setText("");
        this.dayTF.setText("");
        this.dnameTF.setText("");



    }

    private void ToMainFrmActionPerformed() {
        dispose();
        new MainFrm().setVisible(true);
    }

    private void ToMainFixFrmActionPerformed() {
        dispose();
        new DeviceScrapMainFrm().setVisible(true);
    }

}
