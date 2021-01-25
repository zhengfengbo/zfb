package com.bh.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DemoJDBC {
    public void test() throws Exception{
        /**
         * 1.得到connection
         * 2.得到statement，发送select语句
         * 3.对查询返回的表格进行解析
         */
        /**
         * 得到连接
         * 准备四大连接参数
         */
        String driverClassName = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/test?serverTimezone=GMT%2B8&characterEncoding=utf-8&useSSL=FALSE";
        String username = "root";
        String password = "123456";
        /**
        * 加载驱动类
        */
        Class.forName(driverClassName);
        /**
         * 通过三个参数调用DriverManger的getConnection()，得到连接成功
         */
        Connection con = DriverManager.getConnection(url,username,password);
        //------------exeexecuteUpdate(String sql )----------------------
        /*
         * 二、对数据库做增、删、改
         * 1. 通过Connection对象创建Statement
         *     > Statement语句的发送器，它的功能就是向数据库发送sql语句！
         * 2. 调用它的int executeUpdate(String sql)，它可以发送DML、DDL
         */
        // 1. 通过Connection得到Statement对象
        Statement stmt = con.createStatement();
        // 2. 使用Statement发送sql语句！
		//String sql = "INSERT INTO stu VALUES('SDU_0003', 'wangWu', 88, 'male')";
        String sql = "UPDATE stu SET name='zhaoLiu', age=22, gender='female' WHERE number='SDU_0003'";
        //String sql = "DELETE FROM stu";
        int row = stmt.executeUpdate(sql);
        System.out.println(row);

        //----------------------executeQuery(String sql)------------------
        /*
         * 二、得到Statement，执行sql语句
         * 1. 得到Statement对象：
         *     Connection的createStatement()方法
         */
        Statement stmt1 = con.createStatement();
        /*
         * 2. 调用Statement的ResultSet rs = executeQuery(String querySql)
         */
        ResultSet rs = stmt.executeQuery("select * from emp");

        /*
         * 三、解析ResultSet
         * 1. 把行光标移动到第一行，可以调用next()方法完成！
         */
        while(rs.next()) {//把光标向下移动一行，并判断下一行是否存在！
            int empno = rs.getInt(1);//通过列编号来获取该列的值！
            String ename = rs.getString("ename");//通过列名称来获取该列的值
            double sal = rs.getDouble("sal");

            System.out.println(empno +  ", " + ename + ", " + sal);
        }

        /*
         * 四、关闭资源
         * 倒关
         */
        rs.close();
        stmt.close();
        con.close();//


    }
}
