package com.xxc.http.request;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RequestParamServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码格式
        request.setCharacterEncoding("utf-8");
        //如果请求方式是get,仍然会出现乱码问题，可以上网搜索解决
        //同时实际上很少使用get方式发送请求体
        // 从请求中获取名为"username"的参数值
        String name = request.getParameter("username");
        // 从请求中获取名为"password"的参数值
        String password = request.getParameter("password");

        System.out.println("用户名:" + name);
        System.out.println("密 码:" + password);

        // 获取参数名为“hobby”的所有值，因为是复选框，可能有多个值
        String[] hobbys = request.getParameterValues("hobby");
        System.out.print("爱好:");
        if (hobbys != null) {
            for (int i = 0; i < hobbys.length; i++) {
                System.out.print(hobbys[i] + ", ");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
