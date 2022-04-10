package com.test.platform.controller;

import com.test.platform.entity.TestTaskLog;
import com.test.platform.service.TestTaskLogService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (TestTaskLog)表控制层
 *
 * @since 2022-04-09 13:39:09
 */
@Controller
@RequestMapping("testTaskLog")
public class TestTaskLogController {
    /**
     * 服务对象
     */
    @Resource
    private TestTaskLogService testTaskLogService;

    /**
     * 查询
     *
     * @param testTaskLog 筛选条件
     * @return 查询结果
     */
    @GetMapping
    public String queryAll(TestTaskLog testTaskLog, Model model) {
        model.addAttribute("list", testTaskLogService.queryAll(testTaskLog));
        return "testTaskLog";
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    @ResponseBody
    public TestTaskLog queryById(@PathVariable("id") Integer id) {
        return this.testTaskLogService.queryById(id);
    }


    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @GetMapping("/delete/{id}")
    public String deleteById(@PathVariable Integer id) {
        this.testTaskLogService.deleteById(id);
        return "redirect:/testTaskLog";
    }

}

