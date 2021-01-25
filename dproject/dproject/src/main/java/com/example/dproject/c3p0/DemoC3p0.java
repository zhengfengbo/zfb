package com.example.dproject.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

public class DemoC3p0 {
    @Test
    public void fun1() throws PropertyVetoException, SQLException {
        ComboPooledDataSource ds = new ComboPooledDataSource();
        //设置连接池属性
        //url
        ds.setJdbcUrl("jdbc:mysql://@localhost:3306/test?serverTimezone=GMT%2B8&characterEncoding=utf-8&useSSL=FALSE");
        //user
        ds.setUser("root");
        //password
        ds.setPassword("123456");
        //数据库驱动
        ds.setDriverClass("com.mysql.jdbc.Driver");
        //当数据库连接池中没有空闲的连接时，一次性创建的连接数量
        ds.setAcquireIncrement(5);
        //初始化时获取的连接数
        ds.setInitialPoolSize(20);
        //连接池中保留的最小连接数
        ds.setMinPoolSize(2);
        //连接池中保留的最大连接数
        ds.setMaxPoolSize(50);
        //获取池连接
        Connection con = ds.getConnection();
        System.out.println(con);
        con.close();//
    }






}
