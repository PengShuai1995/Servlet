package com.ps.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

public class TwoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1通过请求对象获得【请求头】中【所有请求参数名】
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements())
        {
            String paraName = parameterNames.nextElement();
            //2.通过请求对象读取指定请求参数的值
            String value = request.getParameter(paraName);
            System.out.println("请求参数名：" + paraName + " 请求参数的值： " + value);

        }
    }
}
