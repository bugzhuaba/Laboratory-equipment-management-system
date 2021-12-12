package com.java1234.view;


import com.java1234.dao.DeviceScrapDao;
import com.java1234.model.DeviceScrap;
import com.java1234.util.DbUtil;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;



public class DeviceScrapMainFrm extends JFrame {

    private JPanel contentPane;
    private JTable table;
    private DbUtil dbUtil=new DbUtil();
    private DeviceScrapDao deviceScrapDao=new DeviceScrapDao();


    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    DeviceScrapMainFrm frame = new DeviceScrapMainFrm();
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
    public DeviceScrapMainFrm() {
        setTitle("报废设备主页面");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 929, 569);
        contentPane = new JPanel();
        contentPane.setBackground(Color.PINK);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JScrollPane scrollPane = new JScrollPane();

        JButton btnNewButton = new JButton("添加报废设备");
        btnNewButton.setFont(new Font("宋体", Font.PLAIN, 20));
        btnNewButton.setBackground(new Color(255, 240, 245));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ToAddScrapFrmActionPerformed();
            }
        });

        JButton btnNewButton_1 = new JButton("查询设备报废情况");
        btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 20));
        btnNewButton_1.setBackground(new Color(255, 240, 245));
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ToSelectScrapFrmActionPerformed();
            }
        });
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
                gl_contentPane.createParallelGroup(Alignment.TRAILING)
                        .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 905, Short.MAX_VALUE)
                        .addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
                                .addGap(91)
                                .addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 246, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED, 197, Short.MAX_VALUE)
                                .addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 222, GroupLayout.PREFERRED_SIZE)
                                .addGap(149))
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 269, GroupLayout.PREFERRED_SIZE)
                                .addGap(78)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(119, Short.MAX_VALUE))
        );

        table = new JTable();
        table.setBackground(Color.PINK);
        table.setFont(new Font("宋体", Font.PLAIN, 13));
        table.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                        "\u8BBE\u5907\u540D\u79F0","日期", "\u8FD0\u884C\u72B6\u51B5"
                }
        ));
        table.getColumnModel().getColumn(0).setPreferredWidth(55);
        table.getColumnModel().getColumn(1).setPreferredWidth(59);
        table.getColumnModel().getColumn(2).setPreferredWidth(59);
        scrollPane.setViewportView(table);
        contentPane.setLayout(gl_contentPane);
        this.fillTable(new DeviceScrap());
        this.setLocationRelativeTo(null);
    }

    private void ToSelectScrapFrmActionPerformed() {
        dispose();
        new DeviceScrapSelectFrm().setVisible(true);

    }

    private void ToAddScrapFrmActionPerformed() {
        dispose();
        new AddScrapDeviceFrm().setVisible(true);
    }

    private  void fillTable(DeviceScrap deviceScrap){
        DefaultTableModel dtm=(DefaultTableModel) table.getModel();
        dtm.setRowCount(0);
        Connection con=null;
        try {
            con=dbUtil.getCon();
            ResultSet rs= deviceScrapDao.list(con,deviceScrap);
            while (rs.next()){
                Vector v=new Vector();
                v.add(rs.getString("dname"));
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
}
