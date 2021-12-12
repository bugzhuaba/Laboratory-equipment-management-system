package com.java1234.view;

import com.java1234.dao.DeviceScrapDao;
import com.java1234.model.DeviceScrap;
import com.java1234.util.DbUtil;
import com.java1234.util.StringUtil;

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

public class DeviceScrapSelectFrm extends JFrame {

    private JPanel panel;
    private JTextField nameTF;
    private JTextField yearTF;
    private JTextField monthTF;
    private JTextField dayTF;
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
                    DeviceFixSelectFrm frame = new DeviceFixSelectFrm();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     * Create the frame.
     */
    public DeviceScrapSelectFrm() {
        setTitle("查询设备报废情况");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 719, 618);
        panel = new JPanel();
        panel.setBackground(Color.PINK);
        panel.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(panel);

        JLabel lblNewLabel = new JLabel("\u8BBE\u5907\u540D\uFF1A");
        lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));

        nameTF = new JTextField();
        nameTF.setFont(new Font("宋体", Font.PLAIN, 16));
        nameTF.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("\u4FEE\u7406\u65E5\u671F\uFF1A");
        lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 20));

        yearTF = new JTextField();
        yearTF.setFont(new Font("宋体", Font.PLAIN, 16));
        yearTF.setColumns(10);

        JLabel lblNewLabel_3 = new JLabel("");

        JLabel lblNewLabel_4 = new JLabel("\u5E74");
        lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 20));

        monthTF = new JTextField();
        monthTF.setFont(new Font("宋体", Font.PLAIN, 16));
        monthTF.setColumns(10);

        JLabel lblNewLabel_4_1 = new JLabel("\u6708");
        lblNewLabel_4_1.setFont(new Font("宋体", Font.PLAIN, 20));

        dayTF = new JTextField();
        dayTF.setFont(new Font("宋体", Font.PLAIN, 16));
        dayTF.setColumns(10);

        JLabel lblNewLabel_4_1_1 = new JLabel("\u65E5");
        lblNewLabel_4_1_1.setFont(new Font("宋体", Font.PLAIN, 20));

        JScrollPane scrollPane = new JScrollPane();

        JButton btnNewButton = new JButton("\u8FD4\u56DE\u4E3B\u754C\u9762");
        btnNewButton.setBackground(new Color(255, 245, 238));
        btnNewButton.setFont(new Font("宋体", Font.PLAIN, 18));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ToMainFrmActionPerformed(e);

            }
        });

        JButton btnNewButton_1 = new JButton("\u67E5\u8BE2");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SelectActionPerformed(e);

            }
        });
        btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 18));
        btnNewButton_1.setBackground(new Color(255, 245, 238));
        GroupLayout gl_panel = new GroupLayout(panel);
        gl_panel.setHorizontalGroup(
                gl_panel.createParallelGroup(Alignment.TRAILING)
                        .addGroup(gl_panel.createSequentialGroup()
                                .addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_panel.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 665, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(gl_panel.createSequentialGroup()
                                                .addGap(72)
                                                .addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
                                                        .addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(gl_panel.createSequentialGroup()
                                                                .addGap(140)
                                                                .addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)))))
                                .addContainerGap(20, Short.MAX_VALUE))
                        .addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
                                .addGap(45)
                                .addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
                                        .addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
                                                .addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(nameTF, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
                                                .addComponent(lblNewLabel_2)
                                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                                .addComponent(yearTF, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                                .addGap(18)
                                .addComponent(monthTF, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addComponent(lblNewLabel_4_1, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(dayTF, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(lblNewLabel_4_1_1, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(122, Short.MAX_VALUE))
        );
        gl_panel.setVerticalGroup(
                gl_panel.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_panel.createSequentialGroup()
                                .addGap(21)
                                .addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
                                        .addComponent(lblNewLabel_3)
                                        .addGroup(gl_panel.createSequentialGroup()
                                                .addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
                                                        .addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(nameTF, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
                                                .addGap(6)))
                                .addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_panel.createSequentialGroup()
                                                .addGap(8)
                                                .addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
                                                        .addGroup(gl_panel.createSequentialGroup()
                                                                .addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
                                                                        .addComponent(yearTF, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(lblNewLabel_4))
                                                                .addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                        .addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
                                                                .addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(44)))
                                                .addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
                                                        .addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(gl_panel.createSequentialGroup()
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
                                                        .addComponent(monthTF, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lblNewLabel_4_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(dayTF, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lblNewLabel_4_1_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))))
                                .addGap(55)
                                .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 271, GroupLayout.PREFERRED_SIZE))
        );

        table = new JTable();
        table.setBackground(Color.PINK);
        table.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                        "\u8BBE\u5907\u540D",  "\u4FEE\u7406\u65E5\u671F", "\u62A5\u4FEE\u60C5\u51B5"
                }
        ));
        scrollPane.setViewportView(table);
        panel.setLayout(gl_panel);
        this.setLocationRelativeTo(null);
    }




    private void ToMainFrmActionPerformed(ActionEvent e) {
        dispose();
        new MainFrm().setVisible(true);
    }

    private void SelectActionPerformed(ActionEvent evt) {
        String dyear = this.yearTF.getText();
        String dmonth = this.monthTF.getText();
        String dday = this.dayTF.getText();
        String name = this.nameTF.getText();
        String drun=null;
        String money=null;
        String dutyer=null;
        String data=null;
        if((StringUtil.isNotEmpty(dyear))&&(StringUtil.isNotEmpty(dmonth))&&(StringUtil.isNotEmpty(dday))){
            data=dyear + "-" + dmonth + "-" + dday;
        }
        DeviceScrap deviceScrap=new DeviceScrap(name,data,drun);

        this.fillTable(deviceScrap);
        this.resetValue();

        Connection con = null;




    }




    private void fillTable(DeviceScrap deviceScrap) {

        DefaultTableModel dtm = (DefaultTableModel) table.getModel();
        dtm.setRowCount(0);
        Connection con = null;


        try {
            con = dbUtil.getCon();
            ResultSet rs = deviceScrapDao. scraplist(con, deviceScrap);
            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getString("name"));
                v.add(rs.getString("date"));
                v.add(rs.getString("run"));
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
        this.nameTF.setText("");
        this.yearTF.setText("");
        this.monthTF.setText("");
        this.dayTF.setText("");

    }



}
