package com.ps.util;

import java.net.ConnectException;
import java.sql.*;

public class JdbcUtil {
    final String URL = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC&characterEncoding=UTF-8";
    final String USERNAME = "root";
    final String PASSWORD = "144790";
    PreparedStatement ps = null;
    Connection con = null;
    //将jar包中driver实现类加载到JVM中
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");

        }catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }
    //封装交通工具创建细节
    public Connection getCon()
    {
        try {
            con = DriverManager.getConnection(URL,USERNAME,PASSWORD);

        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        return con;
    }


    public PreparedStatement createStatement(String sql)
    {
        try{
            ps = getCon().prepareStatement(sql);
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        return ps;
    }
    public void close()
    {
        if(ps!= null)
        {
            try {
                ps.close();
            }catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
        if(con != null)
        {
            try {
                con.close();
            }catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
    }


}
