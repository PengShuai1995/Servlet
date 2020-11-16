package com.ps.dao;

import com.ps.entity.Users;
import com.ps.util.JdbcUtil;

import javax.rmi.CORBA.Util;
import javax.sql.rowset.JdbcRowSet;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private JdbcUtil util = new JdbcUtil();
    public int add(Users users){
        String sql = "insert into users(userName,password,sex,email)"+
                     "values(?,?,?,?)";

        PreparedStatement ps = util.createStatement(sql);
        int result = 0;
        try {
            ps.setString(1,users.getUserName());
            ps.setString(2,users.getPassword());
            ps.setString(3,users.getSex());
            ps.setString(4,users.getEmail());
            result = ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            util.close();
        }
        return result;
    }
    public List findAll()
    {
        String sql = "select *from users";
        PreparedStatement ps = util.createStatement(sql);
        ResultSet rs = null;
        List userList = new ArrayList();
        try {
            rs = ps.executeQuery();
            while (rs.next())
            {
                Integer userId = rs.getInt("userId");
                String userName = rs.getString("userName");
                String password = rs.getString("password");
                String sex = rs.getString("sex");
                String email = rs.getString("email");
                Users users = new Users(userId,userName,password,sex,email);
                userList.add(users);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            util.close();
        }
        return userList;
    }
    //根据用户编号删除用户信息
    public int delete(String userId)
    {
        String sql = "delete from users where userId=?";
        PreparedStatement ps = util.createStatement(sql);
        int result = 0;
        try {
            ps.setInt(1,Integer.valueOf(userId));
            result = ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            util.close();
        }
        return result;
    }

    public int login(String userName,String password)
    {
        String sql = "select count(*) from users where userName = ? and password=?";
        PreparedStatement ps = util.createStatement(sql);
        ResultSet rs = null;
        int result = 0;
        try {

            ps.setString(1,userName);
            ps.setString(2,password);
             rs = ps.executeQuery();
             while(rs.next())
             {
                 result = rs.getInt("count(*)");
             }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }finally {
            util.close();
        }
        return result;
    }
}
