package com.test.platform.controller;

import com.test.platform.entity.TestServer;
import com.test.platform.service.TestServerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 服务器配置信息表(TestServer)表控制层
 *
 * @since 2022-04-09 13:39:09
 */
@Controller
@RequestMapping("testServer")
public class TestServerController {
    /**
     * 服务对象
     */
    @Resource
    private TestServerService testServerService;

    /**
     * 查询
     *
     * @param testServer 筛选条件
     * @return 查询结果
     */
    @GetMapping
    public String queryAll(TestServer testServer, Model model) {
        List<TestServer> testServerList = testServerService.queryAll(testServer);
        model.addAttribute("list", testServerList);
        return "testServer";
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    @ResponseBody
    public TestServer queryById(@PathVariable("id") Integer id) {
        return this.testServerService.queryById(id);
    }

    /**
     * 新增数据
     *
     * @param testServer 实体
     * @return 新增结果
     */
    @PostMapping
    public String add(TestServer testServer) {
        testServerService.insert(testServer);
        return "redirect:/testServer";
    }

    /**
     * 编辑数据
     *
     * @param testServer 实体
     * @return 编辑结果
     */
    @PostMapping("/edit")
    public String edit(TestServer testServer) {
        this.testServerService.update(testServer);
        return "redirect:/testServer";
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @GetMapping("/delete/{id}")
    public String deleteById(@PathVariable Integer id) {
        this.testServerService.deleteById(id);
        return "redirect:/testServer";
    }

}

