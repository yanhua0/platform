package com.test.platform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * 网页的跳转控制器
 */
@RequestMapping
@Controller
public class WebPageController {
    /**
     * 首页地址
     *
     * @return
     */
    @GetMapping
    public String indexPage() {
        return "index";
    }

    /**
     * 登录
     *
     * @return
     */
    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    /**
     * 退出登录
     *
     * @return
     */
    @GetMapping("/logout")
    public String loginOutPage(HttpSession httpSession) {
        httpSession.removeAttribute("username");
        return "login";
    }

    /**
     * 统计
     *
     * @return
     */
    @GetMapping("/testStatics")
    public String testStatics() {
        return "statics";
    }
}
