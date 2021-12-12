package com.java1234.view;


import com.java1234.dao.DeviceRunDao;
import com.java1234.dao.DeviceTypeDao;
import com.java1234.model.DeviceRun;
import com.java1234.model.DeviceType;
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
import java.sql.ResultSet;

public class AddFrm extends JFrame {

    private JPanel contentPane;
    private JTextField TypeTF;
    private JTextField NameTF;
    private JTextField ModelTF;
    private JTextField SpecTF;
    private JTextField MoneyTF;
    private JTextField NumTF;
    private JLabel lblNewLabel_2_1_2;
    private JTextField FactoryTF;
    private JLabel lblNewLabel_2_2;
    private JTextField BuyerTF;
    private JLabel lblNewLabel_3;
    private JLabel lblNewLabel_4;
    private JTextField DataTF;
    private DbUtil dbUtil = new DbUtil();
    private DeviceTypeDao deviceTypeDao = new DeviceTypeDao();
    private JLabel label;
    private JTextField crnameTF;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AddFrm frame = new AddFrm();
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
    public AddFrm() {
        ;
        setTitle("\u8BBE\u5907\u5165\u5E93\u7BA1\u7406\u754C\u9762");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setBounds(100, 100, 909, 519);
        contentPane = new JPanel();
        contentPane.setBackground(Color.PINK);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        this.setLocationRelativeTo(null);
        JLabel lblNewLabel = new JLabel("\u7C7B\u522B\uFF1A");
        lblNewLabel.setFont(new Font("等线", Font.PLAIN, 17));

        TypeTF = new JTextField();
        TypeTF.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("\u8BBE\u5907\u540D\uFF1A");
        lblNewLabel_1.setFont(new Font("等线", Font.PLAIN, 17));

        NameTF = new JTextField();
        NameTF.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("\u578B\u53F7\uFF1A");
        lblNewLabel_2.setFont(new Font("等线", Font.PLAIN, 17));

        ModelTF = new JTextField();
        ModelTF.setColumns(10);

        JLabel lblNewLabel_1_1 = new JLabel("\u89C4\u683C\uFF1A");
        lblNewLabel_1_1.setFont(new Font("等线", Font.PLAIN, 17));

        SpecTF = new JTextField();
        SpecTF.setColumns(10);

        MoneyTF = new JTextField();
        MoneyTF.setColumns(10);

        JLabel lblNewLabel_2_1 = new JLabel("\u5355\u4EF7\uFF1A");
        lblNewLabel_2_1.setFont(new Font("等线", Font.PLAIN, 17));

        JLabel lblNewLabel_1_1_1 = new JLabel("\u6570\u91CF\uFF1A");
        lblNewLabel_1_1_1.setFont(new Font("等线", Font.PLAIN, 17));

        NumTF = new JTextField();
        NumTF.setColumns(10);

        JLabel lblNewLabel_2_1_1 = new JLabel("\u8D2D\u7F6E\u65E5\u671F\uFF1A");
        lblNewLabel_2_1_1.setFont(new Font("等线", Font.PLAIN, 17));

        lblNewLabel_2_1_2 = new JLabel("\u751F\u4EA7\u5382\u5BB6\uFF1A");
        lblNewLabel_2_1_2.setFont(new Font("等线", Font.PLAIN, 17));

        FactoryTF = new JTextField();
        FactoryTF.setColumns(10);

        lblNewLabel_2_2 = new JLabel("\u8D2D\u4E70\u4EBA\uFF1A");
        lblNewLabel_2_2.setFont(new Font("等线", Font.PLAIN, 17));

        BuyerTF = new JTextField();
        BuyerTF.setColumns(10);

        JButton btnNewButton = new JButton("\u6DFB\u52A0");
        btnNewButton.setBackground(new Color(255, 245, 238));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    AddActionPerformed(e);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });

        JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resetValueActionPerformed(e);
            }
        });
        btnNewButton_1.setBackground(new Color(255, 245, 238));

        JButton home = new JButton("我要返回啦");
        home.setBackground(new Color(255, 245, 238));
        home.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {
                backhomeActionPerfomed(e);
            }
        }
        );

        JButton message = new JButton("点我查看入库信息");
        message.setBackground(new Color(255, 245, 238));
        message.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                toDeviceTypeSelectFrmActionPerfomed(e);
            }
        });

        lblNewLabel_3 = new JLabel("");

        lblNewLabel_4 = new JLabel("");
        lblNewLabel_4.setIcon(new ImageIcon("src/com/java1234/图片/0-设备管理.png"));

        DataTF = new JTextField();
        DataTF.setColumns(10);

        label = new JLabel("\u673A\u623F\u540D\u79F0\uFF1A");
        label.setFont(new Font("等线", Font.PLAIN, 17));

        crnameTF = new JTextField();
        crnameTF.setColumns(10);

        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
                gl_contentPane.createParallelGroup(Alignment.TRAILING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(39)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGap(26)
                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
                                                        .addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE))
                                                .addGap(55)
                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
                                                        .addComponent(MoneyTF, GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                                                        .addComponent(ModelTF)
                                                        .addComponent(TypeTF))
                                                .addGap(87)
                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                                .addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                                .addComponent(NameTF, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
                                                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                                                .addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                                                .addComponent(SpecTF, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                                                .addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                                                .addComponent(NumTF, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)))
                                                                .addGap(136)
                                                                .addComponent(home, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGap(8)
                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                        .addComponent(lblNewLabel_2_1_1)
                                                        .addComponent(lblNewLabel_2_2))
                                                .addGap(47)
                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
                                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                                .addPreferredGap(ComponentPlacement.RELATED, 149, Short.MAX_VALUE)
                                                                .addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(71))
                                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
                                                                        .addComponent(BuyerTF, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                                                                        .addComponent(DataTF, GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE))
                                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                                                .addGap(78)
                                                                                .addComponent(lblNewLabel_2_1_2, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                                                .addGap(61)
                                                                                .addComponent(label)))
                                                                .addGap(1)))
                                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                        .addComponent(crnameTF, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                                .addComponent(FactoryTF, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(108)
                                                                .addComponent(message, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)))))
                                .addGap(54))
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(120)
                                .addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED, 230, Short.MAX_VALUE)
                                .addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
                                .addGap(141)
                                .addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGap(31)
                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                        .addComponent(TypeTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lblNewLabel)
                                                        .addComponent(lblNewLabel_1)
                                                        .addComponent(NameTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                .addGap(28)
                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                        .addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(SpecTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(ModelTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                .addGap(29)
                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                        .addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(NumTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(MoneyTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                .addGap(28)
                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                        .addComponent(lblNewLabel_2_1_1, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lblNewLabel_2_1_2, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(DataTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(FactoryTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGap(53)
                                                .addComponent(home, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(message)
                                                .addPreferredGap(ComponentPlacement.RELATED)))
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGap(18)
                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                                .addGap(6)
                                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                                        .addComponent(label, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(crnameTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                                .addGap(18)
                                                                .addComponent(lblNewLabel_3)
                                                                .addPreferredGap(ComponentPlacement.RELATED, 144, Short.MAX_VALUE))
                                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                                .addGap(9)
                                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                                        .addComponent(lblNewLabel_2_2, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(BuyerTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
                                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                                        .addComponent(btnNewButton_1)
                                                                        .addComponent(btnNewButton))
                                                                .addGap(79)))
                                                .addGap(33))
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 266, Short.MAX_VALUE))))
        );
        contentPane.setLayout(gl_contentPane);
    }

    private void toDeviceTypeSelectFrmActionPerfomed(ActionEvent e) {
        dispose();
        new DeviceTypeSelectFrm().setVisible(true);
    }


    private void backhomeActionPerfomed(ActionEvent evt) {
        dispose();
        new MainFrm().setVisible(true);
    }

    //设备类别添加事件处理
    private void AddActionPerformed(ActionEvent evt) throws Exception {
        String type = this.TypeTF.getText();
        String name = this.NameTF.getText();
        String model = this.ModelTF.getText();
        String spec = this.SpecTF.getText();
        String money = this.MoneyTF.getText();
        String num = this.NumTF.getText();
        String data = this.DataTF.getText();
        String factory = this.FactoryTF.getText();
        String buyer = this.BuyerTF.getText();
        String crname = this.crnameTF.getText();
        String bbatch=null ;

        DeviceType deviceType = new DeviceType(type, name, model, spec, money, num, data, factory, buyer, bbatch, crname);
        DeviceRun deviceRun = new DeviceRun(name, crname, null,null);
        Connection con = null;

        try {
            con = dbUtil.getCon();
            ResultSet rs = DeviceTypeDao.batchResult(con,deviceType);
            while (rs.next()) {
                bbatch= rs.getString(1);


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
        int n=Integer.parseInt(bbatch)+1;
        String batch=Integer.toString(n);



     DeviceType rnew_deviceType = new DeviceType(type, name, model, spec, money, num, data, factory, buyer, batch, crname);


        if (StringUtil.isEmpty(name)) {
            JOptionPane.showMessageDialog(null, "设备名、设备型号、机房名称、日期不能为空");
            return;
        }
        if (StringUtil.isEmpty(model)) {
            JOptionPane.showMessageDialog(null, "设备名、设备型号、机房名称、日期不能为空");
            return;
        }
        if (StringUtil.isEmpty(crname)) {
            JOptionPane.showMessageDialog(null, "设备名、设备型号、机房名称、日期不能为空");
            return;
        }
        if (StringUtil.isEmpty(data)) {
            JOptionPane.showMessageDialog(null, "设备名、设备型号、机房名称、日期不能为空");
            return;
        }





        try {
            con = dbUtil.getCon();
            int i = DeviceTypeDao.Add(con,  rnew_deviceType);
            int j= DeviceRunDao.Add(con,deviceRun);
            if (i == 1) {
                JOptionPane.showMessageDialog(null, "入库成功！");
                resetValue();
            } else {
                JOptionPane.showMessageDialog(null, "入库失败！");
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "入库失败！");
        } finally {
            try {
                dbUtil.closeCon(con);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }





    //重置事件处理
    private void resetValueActionPerformed(ActionEvent evt) {
        this.resetValue();
    }

    //重置表单
    private void  resetValue(){
        this.TypeTF.setText("");
        this.NameTF.setText("");
        this.ModelTF.setText("");
        this.SpecTF.setText("");
        this.MoneyTF.setText("");
        this.NumTF.setText("");
        this.DataTF.setText("");
        this.FactoryTF.setText("");
        this.BuyerTF.setText("");
        this.crnameTF.setText("");


    }
}


