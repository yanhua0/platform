package com.test.platform.controller;

import com.test.platform.entity.TestTool;
import com.test.platform.service.TestToolService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TestTool)表控制层
 *
 * @since 2022-04-09 13:39:09
 */
@Controller
@RequestMapping("testTool")
public class TestToolController {
    /**
     * 服务对象
     */
    @Resource
    private TestToolService testToolService;

    /**
     * 查询
     *
     * @param testTool 筛选条件
     * @return 查询结果
     */
    @GetMapping
    public String queryAll(TestTool testTool, Model model) {
        List<TestTool> list = testToolService.queryAll(testTool);//查询测试工具
        model.addAttribute("list", list);
        return "testTool";
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public TestTool queryById(@PathVariable("id") Integer id) {
        return this.testToolService.queryById(id);
    }

    /**
     * 新增数据
     *
     * @param testTool 实体
     * @return 新增结果
     */
    @PostMapping
    public String add(TestTool testTool) {
        this.testToolService.insert(testTool);
        return "redirect:/testTool";
    }

    /**
     * 编辑数据
     *
     * @param testTool 实体
     * @return 编辑结果
     */
    @PostMapping("/edit")
    public String edit(TestTool testTool) {
        this.testToolService.update(testTool);
        return "redirect:/testTool";
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @GetMapping("/delete/{id}")
    public String deleteById(@PathVariable Integer id) {
        this.testToolService.deleteById(id);
        return "redirect:/testTool";
    }
}

