
package com.util;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;


public class DBUtil {
    //    日志记录器
    private static Logger logger = LogManager.getLogger();

    private static String url;
    private static String username;
    private static String pwd;

    private static BasicDataSource ds;

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Properties props = new Properties();
            InputStream resourceAsStream = DBUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");
            props.load(resourceAsStream);

            url = props.getProperty("url");
            username = props.getProperty("username");
            pwd = props.getProperty("password");
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage() + "数据库连接失败");
            url = "jdbc:mysql://127.0.0.1:3306/java11";
            username = "root";
            pwd = "root";
        } catch (Exception e) {
            logger.error("数据库连接失败");
            url = "jdbc:mysql://127.0.0.1:3306/java11";
            username = "root";
            pwd = "root";
        } finally {
            ds = new BasicDataSource();
            ds.setUrl(url);
            ds.setUsername(username);
            ds.setPassword(pwd);
        }
    }


    public static Connection getConnection() {
        try {
            return ds.getConnection();
        } catch (SQLException e) {
            logger.error("获取数据库连接失败");
            throw new RuntimeException("获取数据库连接失败");
        }
    }


    public static void close(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                logger.error("获取数据库连接失败");
            }
        }
    }
}
