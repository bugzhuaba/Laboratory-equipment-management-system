package com.java1234.view;

import com.java1234.dao.DeviceFixDao;
import com.java1234.model.DeviceFix;
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

public class DeviceFixSelectFrm extends JFrame {

    private JPanel factoryTF;
    private JTextField nameTF;
    private JTextField textField_1;
    private JTextField yearTF;
    private JTextField monthTF;
    private JTextField dayTF;
    private JTable table;
    private DbUtil dbUtil=new DbUtil();
    private DeviceFixDao deviceFixDao=new DeviceFixDao();

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
     */
    public DeviceFixSelectFrm() {
        setTitle("\u67E5\u8BE2\u8BBE\u5907\u62A5\u4FEE\u60C5\u51B5\u754C\u9762");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 895, 605);
        factoryTF = new JPanel();
        factoryTF.setBackground(Color.PINK);
        factoryTF.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(factoryTF);

        JLabel lblNewLabel = new JLabel("\u8BBE\u5907\u540D\uFF1A");
        lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));

        nameTF = new JTextField();
        nameTF.setFont(new Font("宋体", Font.PLAIN, 16));
        nameTF.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("\u4FEE\u7406\u5382\u5BB6\uFF1A");
        lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 20));

        textField_1 = new JTextField();
        textField_1.setFont(new Font("宋体", Font.PLAIN, 16));
        textField_1.setColumns(10);

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
        GroupLayout gl_factoryTF = new GroupLayout(factoryTF);
        gl_factoryTF.setHorizontalGroup(
                gl_factoryTF.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_factoryTF.createSequentialGroup()
                                .addGroup(gl_factoryTF.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_factoryTF.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 837, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(gl_factoryTF.createSequentialGroup()
                                                .addGap(317)
                                                .addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(24, Short.MAX_VALUE))
                        .addGroup(gl_factoryTF.createSequentialGroup()
                                .addGap(49)
                                .addGroup(gl_factoryTF.createParallelGroup(Alignment.TRAILING)
                                        .addGroup(gl_factoryTF.createSequentialGroup()
                                                .addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
                                                .addGap(20))
                                        .addGroup(gl_factoryTF.createSequentialGroup()
                                                .addComponent(lblNewLabel_2)
                                                .addPreferredGap(ComponentPlacement.RELATED)))
                                .addGroup(gl_factoryTF.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_factoryTF.createSequentialGroup()
                                                .addComponent(yearTF, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addGroup(gl_factoryTF.createParallelGroup(Alignment.LEADING)
                                                        .addGroup(gl_factoryTF.createSequentialGroup()
                                                                .addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                                .addComponent(monthTF, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                .addComponent(lblNewLabel_4_1, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                                .addComponent(dayTF, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                                .addComponent(lblNewLabel_4_1_1, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                                                .addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
                                                .addGap(103))
                                        .addGroup(gl_factoryTF.createSequentialGroup()
                                                .addComponent(nameTF, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
                                                .addGap(94)
                                                .addComponent(lblNewLabel_1)
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(193, Short.MAX_VALUE))))
        );
        gl_factoryTF.setVerticalGroup(
                gl_factoryTF.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_factoryTF.createSequentialGroup()
                                .addGroup(gl_factoryTF.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_factoryTF.createSequentialGroup()
                                                .addGroup(gl_factoryTF.createParallelGroup(Alignment.LEADING)
                                                        .addGroup(gl_factoryTF.createSequentialGroup()
                                                                .addGap(41)
                                                                .addGroup(gl_factoryTF.createParallelGroup(Alignment.BASELINE)
                                                                        .addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(nameTF, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)))
                                                        .addGroup(gl_factoryTF.createSequentialGroup()
                                                                .addGap(45)
                                                                .addGroup(gl_factoryTF.createParallelGroup(Alignment.LEADING)
                                                                        .addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))))
                                                .addGap(36)
                                                .addGroup(gl_factoryTF.createParallelGroup(Alignment.BASELINE)
                                                        .addComponent(yearTF, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lblNewLabel_3)
                                                        .addComponent(lblNewLabel_4)
                                                        .addComponent(monthTF, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lblNewLabel_4_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(dayTF, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lblNewLabel_4_1_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
                                                .addGap(41)
                                                .addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(gl_factoryTF.createSequentialGroup()
                                                .addGap(96)
                                                .addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                                .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 271, GroupLayout.PREFERRED_SIZE))
        );

        table = new JTable();
        table.setBackground(Color.PINK);
        table.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                        "\u8BBE\u5907\u540D", "\u4FEE\u7406\u5382\u5BB6", "\u4FEE\u7406\u65E5\u671F", "\u62A5\u4FEE\u60C5\u51B5"
                }
        ));
        scrollPane.setViewportView(table);
        factoryTF.setLayout(gl_factoryTF);
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
        String ddate = null;
        String name = this.nameTF.getText();
        String factory = this.textField_1.getText();
        String drun=null;
        String money=null;
        String dutyer=null;
        String data=null;
        if((StringUtil.isNotEmpty(dyear))&&(StringUtil.isNotEmpty(dmonth))&&(StringUtil.isNotEmpty(dday))){
            ddate=dyear + "-" + dmonth + "-" + dday;
        }
        DeviceFix deviceFix=new DeviceFix(ddate,name,factory,money,dutyer,drun);

        this.fillTable(deviceFix);
        this.resetValue();

        Connection con = null;




    }




    private void fillTable(DeviceFix deviceFix) {

        DefaultTableModel dtm = (DefaultTableModel) table.getModel();
        dtm.setRowCount(0);
        Connection con = null;


        try {
            con = dbUtil.getCon();
            ResultSet rs = deviceFixDao. Fixlist(con, deviceFix);
            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getString("name"));
                v.add(rs.getString("fix_factory"));
                v.add(rs.getString("fix_date"));
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
        this.textField_1.setText("");
        this.yearTF.setText("");
        this.monthTF.setText("");
        this.dayTF.setText("");

    }



}
