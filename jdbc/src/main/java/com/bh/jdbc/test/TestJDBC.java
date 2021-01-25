package com.bh.jdbc.test;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class TestJDBC {
    @Test
    public void test() throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");
        //connection数据连接对象
        String url = "jdbc:mysql://localhost:3306/test?serverTimezone=GMT%2B8&characterEncoding=utf-8&useSSL=FALSE";
        String username = "root";
        String password = "123456";
        Connection connection = DriverManager.getConnection(url,username,password);
        //statement数据传输对象
        Statement stm = connection.createStatement();

    }
}
