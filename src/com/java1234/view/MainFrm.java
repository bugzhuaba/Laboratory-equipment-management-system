package com.java1234.view;

import com.java1234.CSV.Export;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class MainFrm extends JFrame {


    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainFrm frame = new MainFrm();
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
    public MainFrm() {

        setBackground(Color.WHITE);
        setTitle("\u5B9E\u9A8C\u5BA4\u8BBE\u5907\u7BA1\u7406\u4E3B\u754C\u9762");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 760, 450);
        contentPane = new JPanel();
        contentPane.setBackground(Color.PINK);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        this.setLocationRelativeTo(null);//设置居中

        JLabel lblNewLabel = new JLabel("\u6B22\u8FCE\u4F7F\u7528\u5B9E\u9A8C\u5BA4\u8BBE\u5907\u7BA1\u7406\u7CFB\u7EDF");
        lblNewLabel.setFont(new Font("等线", Font.PLAIN, 20));

        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon("src/com/java1234/图片/实验室管理.png"));

        JButton btnNewButton = new JButton("\u8BBE\u5907\u5165\u5E93\u7BA1\u7406");
        btnNewButton.setBackground(new Color(255, 245, 238));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AddActionPerformed(e);

            }
        });

        JButton btnNewButton_1 = new JButton("报修设备管理");
        btnNewButton_1.setBackground(new Color(255, 245, 238));
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                FixActionPerformed(e);

            }
        });


        JButton btnNewButton_2 = new JButton("\u8BBE\u5907\u8FD0\u884C\u72B6\u51B5\u7EDF\u8BA1");
        btnNewButton_2.setBackground(new Color(255, 245, 238));
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SelectActionPerformed(e);

            }
        });

        JButton btnNewButton_3 = new JButton("\u62A5\u5E9F\u8BBE\u5907\u7BA1\u7406\u529F\u80FD");
        btnNewButton_3.setBackground(new Color(255, 245, 238));
        btnNewButton_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ScrapActionPerformed(e);

            }
        });

        JButton btnNewButton_1_1 = new JButton("\u5BFC\u51FA\u8868\u683C");
        btnNewButton_1_1.setBackground(new Color(255, 245, 238));
        btnNewButton_1_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    new Export().exportToCsv_Student();

                } catch (SQLException ex) {

                    ex.printStackTrace();
                }

            }
        });
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
                gl_contentPane.createParallelGroup(Alignment.TRAILING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(54)
                                .addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 307, GroupLayout.PREFERRED_SIZE)
                                .addGap(18)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
                                        .addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE))
                                .addGap(55)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
                                        .addComponent(btnNewButton_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnNewButton_2, GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE))
                                .addContainerGap(19, Short.MAX_VALUE))
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addContainerGap(248, Short.MAX_VALUE)
                                .addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 278, GroupLayout.PREFERRED_SIZE)
                                .addGap(210))
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addContainerGap(478, Short.MAX_VALUE)
                                .addComponent(btnNewButton_1_1, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
                                .addGap(119))
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(26)
                                .addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
                                .addGap(4)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGap(36)
                                                .addComponent(lblNewLabel_1))
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGap(58)
                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                        .addComponent(btnNewButton)
                                                        .addComponent(btnNewButton_2))
                                                .addGap(86)
                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                        .addComponent(btnNewButton_1)
                                                        .addComponent(btnNewButton_3))))
                                .addPreferredGap(ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                                .addComponent(btnNewButton_1_1)
                                .addGap(50))
        );

        contentPane.setLayout(gl_contentPane);
        contentPane.setLayout(gl_contentPane);
    }

    private void ScrapActionPerformed(ActionEvent e) {
        dispose();
        new DeviceScrapMainFrm().setVisible(true);
    }

    private void FixActionPerformed(ActionEvent e) {
        dispose();
        new DeviceFixMainFrm().setVisible(true);
    }

    private void SelectActionPerformed(ActionEvent evt) {
        dispose();
        new DeviceRunSelectFrm().setVisible(true);
    }

    private void AddActionPerformed(ActionEvent e) {
        dispose();
        new AddFrm().setVisible(true);
    }
}
