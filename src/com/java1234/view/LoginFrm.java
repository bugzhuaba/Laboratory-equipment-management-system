package com.java1234.view;


import com.java1234.dao.UserDao;
import com.java1234.model.User;
import com.java1234.util.DbUtil;
import com.java1234.util.StringUtil;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;

public class LoginFrm extends JFrame {

    private JPanel contentPane;
    private JTextField userNameTxt;
    private JPasswordField passwordTxt;

    private DbUtil dbUtil = new DbUtil();
    private UserDao userDao = new UserDao();

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    LoginFrm frame = new LoginFrm();
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
    public LoginFrm() {

        setBackground(Color.WHITE);
        setTitle("管理员登录");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBackground(Color.PINK);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        this.setLocationRelativeTo(null);//设置居中
        JLabel NewLabel1 = new JLabel("实验室设备管理系统");
        NewLabel1.setFont(new Font("宋体", Font.PLAIN, 20));
        NewLabel1.setIcon(new ImageIcon("测试1\\src\\DbCurriculumDesign\\LaboratoryEquipmentManagement\\view\\resources\\实验室.png"));

        JLabel NewLabel2 = new JLabel("用户名：");
        NewLabel2.setFont(new Font("宋体", Font.PLAIN, 15));

        JLabel NewLabel3 = new JLabel("密码：");
        NewLabel3.setFont(new Font("宋体", Font.PLAIN, 15));

        userNameTxt = new JTextField();
        userNameTxt.setColumns(10);
        passwordTxt = new JPasswordField();

        JButton NewButton1 = new JButton("登录");
        NewButton1.setBackground(new Color(255, 239, 213));
        NewButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loginActionPerformed(e);
            }
        });
        userNameTxt.addKeyListener(new MyKeyListener());//添加一个回车登录监听
        passwordTxt.addKeyListener(new MyKeyListener());//添加一个回车登录监听


        JButton NewButton3 = new JButton("重置");
        NewButton3.setBackground(new Color(255, 239, 213));
        NewButton3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resetValueActionPerformed(e);
            }
        });

        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(53)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addComponent(NewLabel3, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(NewLabel2, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE))
                                .addGap(18)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
                                        .addComponent(passwordTxt)
                                        .addComponent(userNameTxt, GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE))
                                .addContainerGap(127, Short.MAX_VALUE))
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(87)
                                .addComponent(NewLabel1)
                                .addContainerGap(105, Short.MAX_VALUE))
                        .addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
                                .addContainerGap(86, Short.MAX_VALUE)
                                .addComponent(NewButton3, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
                                .addGap(74)
                                .addComponent(NewButton1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
                                .addGap(72))
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(NewLabel1, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(NewLabel2)
                                        .addComponent(userNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(31)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(NewLabel3, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(passwordTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(NewButton3)
                                        .addComponent(NewButton1))
                                .addGap(26))
        );
        contentPane.setLayout(gl_contentPane);

    }


    //登录事件处理
    private void loginActionPerformed(ActionEvent e) {
        // TODO 自动生成的方法存根
        String userName = this.userNameTxt.getText();
        String password = new String(this.passwordTxt.getText());
        if (StringUtil.isEmpty(userName)) {
            JOptionPane.showMessageDialog(null, "用户名不能为空");
            return;
        }
        if (StringUtil.isEmpty(password)) {
            JOptionPane.showMessageDialog(null, "密码不能为空");
            return;
        }
        User user = new User(userName, password);
        Connection con;
        try {
            con = dbUtil.getCon();
            User currentUser = userDao.login(con, user);
            if (currentUser != null) {
                dispose();
                new MainFrm().setVisible(true);

            } else {
                JOptionPane.showMessageDialog(null, "用户名或密码错误！");
                System.out.println(userName);
                System.out.println(password);

            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }


    }

    //登录事件处理的重载，按回车登录
    private void loginActionPerformed(KeyEvent e) {
        // TODO 自动生成的方法存根
        String userName = this.userNameTxt.getText();
        String password = new String(this.passwordTxt.getText());
        if (StringUtil.isEmpty(userName)) {
            JOptionPane.showMessageDialog(null, "用户名不能为空");
            return;
        }
        if (StringUtil.isEmpty(password)) {
            JOptionPane.showMessageDialog(null, "密码不能为空");
            return;
        }
        User user = new User(userName, password);
        Connection con = null;
        try {
            con = dbUtil.getCon();
            User currentUser = userDao.login(con, user);
            if (currentUser != null) {
                dispose();
                new MainFrm().setVisible(true);

            } else {
                JOptionPane.showMessageDialog(null, "用户名或密码错误！");
                System.out.println(userName);
                System.out.println(password);

            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }finally {
            try {
                dbUtil.closeCon(con);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }

    }

    //重置事件处理
    private void resetValueActionPerformed(ActionEvent evt) {
        // TODO 自动生成的方法存根
        this.userNameTxt.setText("");
        this.passwordTxt.setText("");
    }

    //回车登录的监听
    class MyKeyListener implements KeyListener {
        @Override
        public void keyPressed(KeyEvent e) {
            int KeyCode = e.getKeyCode();
            if (KeyCode == KeyEvent.VK_ENTER) {
                loginActionPerformed(e);
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }

        @Override
        public void keyTyped(KeyEvent e) {

        }
    }
}
