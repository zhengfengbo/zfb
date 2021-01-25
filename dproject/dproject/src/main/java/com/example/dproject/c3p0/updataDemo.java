package com.example.dproject.c3p0;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.junit.Test;

import javax.activation.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class updataDemo {
    @Test
    public void testUpdate() throws SQLException {
        //创建对象
        QueryRunner queryRunner = new QueryRunner();
        Connection connection = null;
        try{
            connection = JdbcUtils.getConnection();
        }catch (SQLException e){
            System.out.println("连接异常");
        }
        String sql = "insert into user values(?,?,?)";
        try {
            queryRunner.update(connection,sql,"4","长青店","大学路");
        }catch (SQLException e){
            e.printStackTrace();
        }

    @Test
        public void fun6() throws SQLException {
            DataSource ds = JdbcUtils.getDataSource();
            QueryRunner qr = new QueryRunner((javax.sql.DataSource) ds);
            String sql = "select * from tab_student where number=?";
            Map<String,Object> map = qr.query(sql, new MapHandler(), "S_2000");
            System.out.println(map);
        }
    @Test
        public void fun2() throws SQLException {
            DataSource ds = JdbcUtils.getDataSource();
            QueryRunner qr = new QueryRunner((javax.sql.DataSource) ds);
            String sql = "select * from tab_student";
            List<Map<String,Object>> list = qr.query(sql, new MapListHandler());
            for(Map<String,Object> map : list) {
                System.out.println(map);
            }  }

        }
    }

