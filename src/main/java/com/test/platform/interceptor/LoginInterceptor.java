package com.test.platform.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Slf4j
public class LoginInterceptor implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //首先进入的方法
        //return false表示拦截，不向下执行
        //return true表示放行
//        System.out.println(request.getServletPath());
        HttpSession session = request.getSession();
        String name = (String) session.getAttribute("username");
        String url = request.getRequestURI();
        if (url.indexOf("/login") >= 0) {
            return true;
        }
        if (url.indexOf("/logout") >= 0) {
            return true;
        }
        if (url.indexOf("/userInfo/subLogin") >= 0) {
            return true;
        }
        if (url.indexOf("/userInfo") >= 0) {
            return true;
        }
        if (url.startsWith("/image")) {
            return true;
        }
        if (url.startsWith("/testServer/query")) {
            return true;
        }
        if (name != null) {
            return true;
        }
        log.info("用户未登录!reqUrl={}", url);
        response.sendRedirect("/login");
        return false;

    }
    //返回modelAndView之前执行

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        // System.out.println("postHandle");
    }
    //执行Handler完成执行此方法

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

//        System.out.println("afterCompletion");
    }
}