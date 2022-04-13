package com.test.platform.controller;

import com.test.platform.entity.UserInfo;
import com.test.platform.service.UserInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * (UserInfo)表控制层
 *
 * @since 2022-04-11 20:41:34
 */
@RequestMapping("userInfo")
@Controller
public class UserInfoController {
    /**
     * 服务对象
     */
    @Resource
    private UserInfoService userInfoService;

    /**
     * 查询
     *
     * @param userInfo 筛选条件
     * @return 查询结果
     */
    @PostMapping("/subLogin")
    public String queryAll(UserInfo userInfo, HttpSession session) {
        List<UserInfo> userInfoList = userInfoService.queryAll(userInfo);
        if (CollectionUtils.isEmpty(userInfoList)) {
            return "redirect:/login";
        }
        session.setAttribute("username",userInfoList.get(0).getUsername());
        return "redirect:/";
    }


    /**
     * 新增数据
     *
     * @param userInfo 实体
     * @return 新增结果
     */
    @PostMapping
    public String add(UserInfo userInfo) {
        this.userInfoService.insert(userInfo);
        return "redirect:/login";
    }


}

