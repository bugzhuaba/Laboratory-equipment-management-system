package com.java1234.view;

import com.java1234.dao.DeviceRunDao;
import com.java1234.model.DeviceRun;
import com.java1234.util.DbUtil;
import com.java1234.util.StringUtil;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;


/**
     * Launch the application.
     */


    /**
     * Create the frame.
     */
    public class DeviceRunSelectFrm extends JFrame {

        private JPanel contentPane;
        private JTextField dnameTF;
        private JTextField crnameTF;
        private JTextField yearTF;
        private JLabel lblNewLabel_1_2;
        private JTextField monthTF;
        private JTextField dayTF;
        private JLabel lblNewLabel_1_3;
        private JButton btnNewButton;
        private JButton btnNewButton_1;
        private JButton btnNewButton_2;
        private JTable table;
        private DbUtil dbUtil = new DbUtil();
        private DeviceRunDao deviceRunDao = new DeviceRunDao();


        /**
         * Launch the application.
         */
        public static void main(String[] args) {
            EventQueue.invokeLater(new Runnable() {
                public void run() {
                    try {
                        DeviceRunSelectFrm frame = new DeviceRunSelectFrm();
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
        public DeviceRunSelectFrm() {
            setBackground(Color.WHITE);
            setTitle("\u8BBE\u5907\u8FD0\u884C\u72B6\u51B5\u67E5\u8BE2");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setBounds(100, 100, 885, 719);
            contentPane = new JPanel();
            contentPane.setBackground(Color.PINK);
            contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
            setContentPane(contentPane);

            JLabel lblNewLabel = new JLabel("\u8BBE\u5907\u540D\u79F0\uFF1A");
            lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 23));

            dnameTF = new JTextField();
            dnameTF.setColumns(10);

            JLabel lblNewLabel_2 = new JLabel("\u673A\u623F\u540D\u79F0\uFF1A");
            lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 23));

            crnameTF = new JTextField();
            crnameTF.setColumns(10);

            JLabel lblNewLabel_1 = new JLabel("\u65E5\u671F\uFF1A");
            lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 23));

            yearTF = new JTextField();
            yearTF.setColumns(10);

            JLabel lblNewLabel_1_1 = new JLabel("\u5E74");
            lblNewLabel_1_1.setFont(new Font("宋体", Font.PLAIN, 23));

            lblNewLabel_1_2 = new JLabel("\u6708");
            lblNewLabel_1_2.setFont(new Font("宋体", Font.PLAIN, 23));

            monthTF = new JTextField();
            monthTF.setColumns(10);

            dayTF = new JTextField();
            dayTF.setColumns(10);

            lblNewLabel_1_3 = new JLabel("\u65E5");
            lblNewLabel_1_3.setFont(new Font("宋体", Font.PLAIN, 23));

            btnNewButton = new JButton("\u67E5\u8BE2");
            btnNewButton.setBackground(new Color(255, 239, 213));
            btnNewButton.setFont(new Font("宋体", Font.PLAIN, 24));
            btnNewButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    SelectActionPerformed(e);
                }
            });

            btnNewButton_1 = new JButton("\u8FD4\u56DE\u4E3B\u9875\u9762");
            btnNewButton_1.setBackground(new Color(255, 255, 240));
            btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 24));
            btnNewButton_1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    ToMainActionPerformed();
                }
            });

            btnNewButton_2 = new JButton("\u4FEE\u6539\u8FD0\u884C\u4FE1\u606F");
            btnNewButton_2.setBackground(new Color(255, 255, 240));
            btnNewButton_2.setFont(new Font("宋体", Font.PLAIN, 24));
            btnNewButton_2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    ToUpdataActionPerformed();
                }
            });

            JScrollPane scrollPane = new JScrollPane();
            GroupLayout gl_contentPane = new GroupLayout(contentPane);
            gl_contentPane.setHorizontalGroup(
                    gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(gl_contentPane.createSequentialGroup()
                                    .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                            .addGroup(gl_contentPane.createSequentialGroup()
                                                    .addGap(59)
                                                    .addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(yearTF, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(monthTF, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(lblNewLabel_1_2, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                                                    .addGap(38))
                                            .addGroup(gl_contentPane.createSequentialGroup()
                                                    .addContainerGap()
                                                    .addComponent(lblNewLabel)
                                                    .addGap(18)
                                                    .addComponent(dnameTF, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
                                                    .addGap(110)
                                                    .addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
                                                    .addGap(13)))
                                    .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                                            .addGroup(gl_contentPane.createSequentialGroup()
                                                    .addGap(20)
                                                    .addComponent(crnameTF, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
                                            .addGroup(gl_contentPane.createSequentialGroup()
                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(dayTF, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
                                                    .addGap(18)
                                                    .addComponent(lblNewLabel_1_3, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)))
                                    .addGap(83)
                                    .addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
                                    .addContainerGap(36, Short.MAX_VALUE))
                            .addGroup(gl_contentPane.createSequentialGroup()
                                    .addContainerGap(158, Short.MAX_VALUE)
                                    .addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)
                                    .addGap(128)
                                    .addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                                    .addGap(198))
                            .addGroup(gl_contentPane.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 841, Short.MAX_VALUE)
                                    .addContainerGap())
            );
            gl_contentPane.setVerticalGroup(
                    gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(gl_contentPane.createSequentialGroup()
                                    .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                                            .addGroup(gl_contentPane.createSequentialGroup()
                                                    .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                            .addGroup(gl_contentPane.createSequentialGroup()
                                                                    .addGap(23)
                                                                    .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                            .addComponent(crnameTF, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                                                                            .addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
                                                                            .addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)))
                                                            .addGroup(gl_contentPane.createSequentialGroup()
                                                                    .addGap(26)
                                                                    .addComponent(dnameTF, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)))
                                                    .addGap(18)
                                                    .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                            .addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(yearTF, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(lblNewLabel_1_3, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(dayTF, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(lblNewLabel_1_2, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(monthTF, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE))
                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                                                    .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                            .addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
                                                    .addGap(15))
                                            .addGroup(gl_contentPane.createSequentialGroup()
                                                    .addGap(36)
                                                    .addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)))
                                    .addGap(40)
                                    .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 383, GroupLayout.PREFERRED_SIZE)
                                    .addContainerGap())
            );

            table = new JTable();
            table.setFont(new Font("楷体", Font.PLAIN, 15));
            table.setModel(new DefaultTableModel(
                    new Object[][]{
                    },
                    new String[]{
                            "\u8BBE\u5907\u540D\u79F0", "\u673A\u623F\u540D\u79F0", "\u65E5\u671F", "\u8BBE\u5907\u8FD0\u884C\u72B6\u51B5"
                    }
            ));
            table.setBackground(Color.PINK);
            scrollPane.setViewportView(table);

            JScrollBar scrollBar = new JScrollBar();
            scrollPane.setRowHeaderView(scrollBar);
            contentPane.setLayout(gl_contentPane);
            this.setLocationRelativeTo(null);
        }



        private void SelectActionPerformed(ActionEvent evt) {
            String dname = this.dnameTF.getText();
            String crname = this.crnameTF.getText();
            String dyear = this.yearTF.getText();
            String dmonth = this.monthTF.getText();
            String dday = this.dayTF.getText();
            String ddate = null;
            String drun=null;
            String type=null;
            String model=null;
            String spec=null;
            String money=null;
            String num=null;
            String data=null;
            String factory=null;
            String buyer=null;
            String batch=null;
            if((StringUtil.isNotEmpty(dyear))&&(StringUtil.isNotEmpty(dmonth))&&(StringUtil.isNotEmpty(dday))){
                ddate=dyear + "-" + dmonth + "-" + dday;
            }
            DeviceRun deviceRun=new DeviceRun(dname,crname,ddate,drun);
            //DeviceType deviceType=new DeviceType(type,dname,model,spec,money,num,data,factory,buyer,batch,crname);
            this.fillTable(deviceRun);
            this.resetValue();

           // Connection con = null;

        }

        private void ToMainActionPerformed() {
            dispose();
            new MainFrm().setVisible(true);
        }
        private void ToUpdataActionPerformed() {
            dispose();
            new DeviceRunUpdataFrm().setVisible(true);
        }

        private void fillTable(DeviceRun deviceRun) {

            DefaultTableModel dtm = (DefaultTableModel) table.getModel();
            dtm.setRowCount(0);
            Connection con = null;

            try {
                con = dbUtil.getCon();
                deviceRunDao.ScrapUpdate(con,deviceRun);
                deviceRunDao.FixUpdate(con,deviceRun);
                ResultSet rs = deviceRunDao.list(con, deviceRun);

                while (rs.next()) {
                    Vector v = new Vector();
                    v.add(rs.getString("dname"));
                    v.add(rs.getString("crname"));
                    v.add(rs.getString("ddate"));
                    v.add(rs.getString("drun"));

                    dtm.addRow(v);

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

        }



        private void resetValue() {
            this.dnameTF.setText("");
            this.crnameTF.setText("");
            this.yearTF.setText("");
            this.monthTF.setText("");
            this.dayTF.setText("");

        }
    }

