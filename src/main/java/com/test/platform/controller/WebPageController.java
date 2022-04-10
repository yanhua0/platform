package com.test.platform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 网页的跳转控制器
 */
@RequestMapping
@Controller
public class WebPageController {
    @GetMapping
    public String indexPage() {
        return "index";
    }
}
