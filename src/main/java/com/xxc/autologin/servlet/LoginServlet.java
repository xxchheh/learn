package com.xxc.autologin.servlet;

import com.xxc.autologin.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取用户与密码
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        //检查用户名与密码
        if (("xxc").equals(username) && ("123456").equals(password)) {
            //登录成功
            //将用户状态user对象存入session域
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            req.getSession().setAttribute("user", user);
            //发送自动登录的cookie
            String autologin = req.getParameter("autologin");
            Integer durationDays = 0;

            // 将文本描述映射为天数
            switch (autologin) {
                case "One Month":
                    durationDays = 30;
                    break;
                case "Three Months":
                    durationDays = 90;
                    break;
                case "Six Months":
                    durationDays = 180;
                    break;
                case "One Year":
                    durationDays = 365;
                    break;
                default:
                    // 设置默认值或抛出异常
                    durationDays = 365;
            }
//            String autologin = req.getParameter("autologin");
            if (autologin != null) {
                Cookie cookie = new Cookie("durationDays", username +"-"+password);
                cookie.setMaxAge(durationDays);
                cookie.setPath(req.getContextPath());
                resp.addCookie(cookie);
            }
            //跳转至首页
            resp.sendRedirect(req.getContextPath() + "/home.jsp");
//            resp.sendRedirect("http://localhost:8080/project1/home.jsp");
        }else {
            req.setAttribute("error","用户名或者密码错误");
            req.getRequestDispatcher(req.getContextPath() + "/login.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
