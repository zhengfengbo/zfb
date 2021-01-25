package com.bh.jdbc.test;


import org.springframework.jdbc.support.JdbcUtils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class jdbcUtil {
        //定义连接数据库的参数
        private static String url;
        private static String username;//用户名
        private static String password;//密码
        private static String driver;

        //创建静态代码块读取配置文件
        static {
            try {
                InputStream inputStream = JdbcUtils.class.getResourceAsStream("bcconfig.properties");
                Properties properties = new Properties();
                properties.load(inputStream);
                String dirverclassname = properties.getProperty("driverclassname");
                url = properties.getProperty("url");
                username = properties.getProperty("username");
                password = properties.getProperty("passwrod");
                //加载驱动
                Class.forName(dirverclassname);
            } catch (IOException e) {
                //e.printStackTrace();
                System.out.println("读取配置文件失败！");
            } catch (ClassNotFoundException cne) {
                System.out.println("加载驱动失败！");
            }


        /*public static Connection getConnection(){
              //连接数据库
                Connection connection = null;
                try {
                    connection = DriverManager.getConnection(url, username, password);
                } catch (SQLException e) {
                    System.out.println("连接数据库失败");
                }
                return connection;
            }*/
        }
    }


