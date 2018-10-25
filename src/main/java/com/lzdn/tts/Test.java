package com.lzdn.tts;

import com.lzdn.common.util.MD5Util;
import org.apache.shiro.codec.Base64;

import java.sql.*;

public class Test {
    static final String DB_URL = "jdbc:mysql://39.105.85.203/lee";
    // MySQL的JDBC URL编写方式：jdbc:mysql://主机名称：连接端口/数据库的名称
    static final String USER = "root";
    static final String PASS = "qwe234*()";

    public static void main(String[] args) throws SQLException,Exception{
        Connection conn = null;
        Statement stat = null;

        // 注册驱动
        Class.forName("com.mysql.jdbc.Driver");

        // 创建链接
        conn = (Connection) DriverManager.getConnection(DB_URL,USER,PASS);

        // 执行查询
        stat = conn.createStatement();
        String sql = "SELECT * FROM cpy_activity WHERE activity_name LIKE '%满%'";
        ResultSet rs = stat.executeQuery(sql);
        // 输出查询结果
        while(rs.next()){
            System.out.print(rs.getString("activity_name" )+",");
//            System.out.print(rs.getString("name")+",");
//            System.out.print(rs.getString("sex")+",");
//            System.out.print(rs.getInt("age"));
            System.out.print("\n");
        }
        // 关闭
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stat != null) {
                    stat.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (conn != null) {
                        conn.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
