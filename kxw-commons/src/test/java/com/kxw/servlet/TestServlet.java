package com.kxw.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by kangxiongwei on 16/6/9 上午11:04.
 */
public class TestServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().write("{user:zhang, name:san}");
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        String user = req.getParameter("user");
        String name = req.getParameter("name");
        PrintWriter writer = resp.getWriter();
        StringBuffer buffer = new StringBuffer("请求参数为:");
        if (user != null && !"".equals(user)) buffer.append(" user:" + user);
        if (name != null && !"".equals(name)) buffer.append(" name:" + name);
        writer.println(buffer.toString());
        writer.flush();
    }
}
