package com.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 抽象类作用：降低接口实现类对接口实现过程难度，
 * 将接口中不需要使用抽象方法交给抽象类进行完成
 * 这样接口实现类只需要对接口需要方法进行重写
 */
public class OneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("OneServlet针对浏览器发送GET请求方式处理");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("OneServlet针对浏览器发送POST请求方式处理");
    }
}
