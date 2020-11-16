package com.ps.controller;

import com.ps.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName,password;
        UserDao dao = new UserDao();
        int res = 0;
        //1.调用请求对象对请求体使用utf-8字符集进行重新编辑
        request.setCharacterEncoding("utf-8");
        //2.调用【请求对象】读取请求体参数信息
        userName = request.getParameter("userName");
        password = request.getParameter("password");
        //3、调用Dao将查询验证信息推送到数据库服务器上
        res = dao.login(userName,password);
        //4.调用响应对象，根据验证结果讲不通资源文件地址写入到响应体，交给浏览器
        if(res == 1)
        {
            //用户存在
            response.sendRedirect("index.html");
        }else
        {
            response.sendRedirect("login_error.html");
        }
    }


}
