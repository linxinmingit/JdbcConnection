package com.yr;

import java.sql.*;

public class DBTest {
    //mysql��������
    private static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
    //���ݿ����ӵ�ַ
    private static final String URL = "jdbc:mysql://localhost:3306/local";
    //�û���
    private static final String USER_NAME = "root";
    //����
    private static final String PASSWORD = "root";

    public static void main(String[] args)
    {
        test();
    }

    public static void test()
    {
        Connection connection = null;
        try {
            //����mysql��������
            Class.forName(DRIVER_NAME);
            //��ȡ���ݿ�����
            connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            //mysql��ѯ���
            String sql = "SELECT * FROM users";
            PreparedStatement prst = connection.prepareStatement(sql);
            //�����
            ResultSet rs = prst.executeQuery();
            while (rs.next()) {
                System.out.println("ID"+rs.getInt("id")+"�û���:" + rs.getString("name")+"���䣺"+rs.getInt("age"));
            }
            rs.close();
            prst.close();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
