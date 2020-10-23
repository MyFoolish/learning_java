package com.xwcoding.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author liuxiaowei
 * @description
 * @date 2020/8/21 12:15
 */
public class DruidUtils {
    // 1、声明静态数据源成员变量
    private static DataSource dataSource;

    // 2、创建连接池对象
    static {
        // 加载配置文件中的数据
        InputStream inputStream = DruidUtils.class.getResourceAsStream("/druid.properties");
        Properties properties = new Properties();
        try {
            properties.load(inputStream);
            // 创建连接池，使用配置文件中的参数
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 3. 定义公有的得到数据源的方法
    public static DataSource getDataSource() {
        return dataSource;
    }

    // 4、定义得到连接对象的方法
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public static void closeResource(Connection connection, Statement statement, ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // 6.重载关闭方法
    public static void closeResource(Connection connection, Statement statement) {
        closeResource(connection, statement, null);
    }

}
