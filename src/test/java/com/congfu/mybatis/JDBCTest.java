package com.congfu.mybatis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class JDBCTest {

    public static void main(String[] args) throws ClassNotFoundException, SQLException{
        doConnect();
    }
    
    public static void doConnect() throws ClassNotFoundException, SQLException{
        String url = "jdbc:mysql://121.196.222.248:3306/congfu?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull";
        String username = "root";
        String password = "12345678";
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = (Connection) DriverManager.getConnection(url, username, password);
        String sql = "SELECT id, name, age, sex from student where id= ?";
        PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
        ps.setInt(1, 1);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            System.out.println(rs.getInt(1));
            System.out.println(rs.getString(2));
            System.out.println(rs.getInt(3));
            System.out.println(rs.getString(4));
        }
        rs.close();
        ps.close();
        conn.close();
    }

}
