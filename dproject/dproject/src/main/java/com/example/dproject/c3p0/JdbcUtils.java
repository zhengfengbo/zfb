package com.example.dproject.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.activation.DataSource;
import java.sql.Connection;

public class JdbcUtils {
    private static DataSource dataSource = new DataSource();

    public static DataSource getDataSource() {
        return dataSource;  }

    public static Connection getConnection() {
        try {    return dataSource.getConnection();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
