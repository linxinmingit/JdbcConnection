package com.connection;

import java.sql.*;

public class DB {
    //mysql��������
    private static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
    //���ݿ����ӵ�ַ
    private static final String URL = "jdbc:mysql://localhost:3306/local";
    //�û���
    private static final String USER_NAME = "root";
    //����
    private static final String PASSWORD = "root";

    public static Connection  testConnetion()
    {
        Connection connection = null;
        try {
            //����mysql��������
            Class.forName(DRIVER_NAME);
            //��ȡ���ݿ�����
            connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  connection;
    }
}
