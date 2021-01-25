package com.bh.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;


public class stat {
    /*
     * 数据库连接
     * @return
     */
    public static void getConnection() throws Exception {
        Connection connection = null; //数据库连接对象

        //加载驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/test?serverTimezone=GMT%2B8&characterEncoding=utf-8&useSSL=FALSE";
        String username = "root";
        String password = "123456";
        //获取连接
        connection = DriverManager.getConnection(url, username, password);


    }

}
