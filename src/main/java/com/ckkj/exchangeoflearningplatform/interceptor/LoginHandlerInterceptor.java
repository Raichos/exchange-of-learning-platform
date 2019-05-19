package com.ckkj.exchangeoflearningplatform.interceptor;


import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登陆检查
 * @author lzh
 * create 2019-05-10-22:22
 */

@Component
public class LoginHandlerInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        Object user = request.getSession().getAttribute("loginUser");

        if (user == null) {
            request.getSession().setAttribute("requestUrl",request.getRequestURI());
            System.out.println("没有权限请先登陆");
            //未登陆，返回登陆界面
            request.setAttribute("msg","没有权限请先登陆");
            request.getRequestDispatcher("/login").forward(request,response);
            return false;
        } else {
            //已登陆，放行请求
            request.getSession().setAttribute("requestUrl","");
            return true;
        }
    }
}
