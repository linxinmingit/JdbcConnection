package com.connection;

import java.sql.*;

public class DB {
    //mysql驱动包名
    private static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
    //数据库连接地址
    private static final String URL = "jdbc:mysql://localhost:3306/local";
    //用户名
    private static final String USER_NAME = "root";
    //密码
    private static final String PASSWORD = "root";

    public static Connection  testConnetion()
    {
        Connection connection = null;
        try {
            //加载mysql的驱动类
            Class.forName(DRIVER_NAME);
            //获取数据库连接
            connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  connection;
    }
}
