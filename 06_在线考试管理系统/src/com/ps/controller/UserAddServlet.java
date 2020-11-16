package com.ps.controller;

import com.ps.dao.UserDao;
import com.ps.entity.Users;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;

public class UserAddServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName,password,sex,email;
        UserDao dao = new UserDao();
        Users users = null;
        int res = 0;
        PrintWriter out = null;
        //1 【调用请求对象】读取【请求头】参数信息，得到用户的信息
        userName = request.getParameter("userName");
        password = request.getParameter("password");
        sex = request.getParameter("sex");
        email = request.getParameter("email");

        //2 【调用UserDao】将用户信息填充到INSERT命令，并借助JDBC规范发送到JDBC服务器
        users = new Users(null,userName,password,sex,email);
        res = dao.add(users);

        //3 【调用相应对象】将【处理结果】以二进制形式写入到响应体
        response.setContentType("text/html;charset=utf-8");
        out = response.getWriter();
        if(res == 1)
        {
            out.print("<font style = 'color:red;font-size:40'>用户信息注册成功！</font>");
        }else
        {
            out.print("<font style = 'color:red;font-size:40'>用户信息注册失败！</font>");
        }
        //Tomcat负责销毁【请求对象】和【响应对象】
        //Tomcat负责将Http响应协议包推送到发起请求的浏览器上
        //浏览器根据响应头content-type指定编译器对响应体二进制内容编辑
        //浏览器将编辑后结果在窗口中展示给用户【结束】
    }
}
