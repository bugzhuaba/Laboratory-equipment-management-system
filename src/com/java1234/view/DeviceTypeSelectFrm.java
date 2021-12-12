package com.java1234.view;

import com.java1234.dao.DeviceTypeDao;
import com.java1234.model.DeviceType;
import com.java1234.util.DbUtil;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;


public class DeviceTypeSelectFrm extends JFrame {

    private JPanel contentPane;
    private JTable table;
    private JButton btnNewButton;
    private DbUtil dbUtil=new DbUtil();
    private DeviceTypeDao deviceTypeDao=new DeviceTypeDao();

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    DeviceTypeSelectFrm frame = new DeviceTypeSelectFrm();
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
    public DeviceTypeSelectFrm() {
        setTitle("\u5165\u5E93\u7BA1\u7406\u4FE1\u606F");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 961, 443);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JScrollPane scrollPane = new JScrollPane();


        table = new JTable();
        table.setBackground(new Color(255, 175, 175));
        table.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                        "\u7C7B\u522B", "\u8BBE\u5907\u540D", "\u578B\u53F7", "\u89C4\u683C", "\u5355\u4EF7", "\u6570\u91CF", "\u8D2D\u7F6E\u65E5\u671F", "\u751F\u4EA7\u5382\u5BB6", "\u8D2D\u4E70\u4EBA", "\u6279\u6B21","机房名称"
                }
        ));

        table.getColumnModel().getColumn(0).setPreferredWidth(55);
        table.getColumnModel().getColumn(1).setPreferredWidth(59);
        table.getColumnModel().getColumn(2).setPreferredWidth(53);
        table.getColumnModel().getColumn(3).setPreferredWidth(51);
        table.getColumnModel().getColumn(4).setPreferredWidth(54);
        table.getColumnModel().getColumn(5).setPreferredWidth(50);
        table.getColumnModel().getColumn(6).setPreferredWidth(92);
        table.getColumnModel().getColumn(7).setPreferredWidth(150);
        table.getColumnModel().getColumn(8).setPreferredWidth(50);
        table.getColumnModel().getColumn(9).setPreferredWidth(50);
        scrollPane.setViewportView(table);
        scrollPane.setViewportView(table);
        this.fillTable(new DeviceType());
        btnNewButton = new JButton("\u8FD4\u56DE\u4E3B\u754C\u9762");
        btnNewButton.setBackground(Color.pink);
        btnNewButton.setIcon(new ImageIcon("src/com/java1234/图片/返回.png"));
        btnNewButton.setFont(new Font("等线", Font.PLAIN, 24));
        this.setLocationRelativeTo(null);
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ToMainFrmActionPerformed(e);

            }
        });
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
                gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 937, Short.MAX_VALUE))
                                .addContainerGap())
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 344, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        contentPane.setLayout(gl_contentPane);

    }

    private void ToMainFrmActionPerformed(ActionEvent e) {
        dispose();
        new MainFrm().setVisible(true);
    }


    //初始化表格
    private  void fillTable(DeviceType deviceType){
        DefaultTableModel dtm=(DefaultTableModel) table.getModel();
        dtm.setRowCount(0);
        Connection con=null;
        try {
            con=dbUtil.getCon();
            ResultSet rs=deviceTypeDao.list(con,deviceType);
            while (rs.next()){
                Vector v=new Vector();
                v.add(rs.getString("type"));
                v.add(rs.getString("name"));
                v.add(rs.getString("model"));
                v.add(rs.getString("spec"));
                v.add(rs.getString("money"));
                v.add(rs.getString("num"));
                v.add(rs.getString("data"));
                v.add(rs.getString("factory"));
                v.add(rs.getString("buyer"));
                v.add(rs.getString("batch"));
                v.add(rs.getString("crname"));
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
