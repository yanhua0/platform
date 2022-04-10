package com.test.platform.controller;

import com.test.platform.entity.TestTask;
import com.test.platform.service.TestTaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TestTask)表控制层
 *
 * @since 2022-04-09 13:39:09
 */
@Controller
@RequestMapping("testTask")
public class TestTaskController {
    /**
     * 服务对象
     */
    @Resource
    private TestTaskService testTaskService;

    /**
     * 查询
     *
     * @param testTask 筛选条件
     * @return 查询结果
     */
    @GetMapping
    public String queryAll(TestTask testTask, Model model) {
        model.addAttribute("list", testTaskService.queryAll(testTask));
        return "testTask";
    }

    @GetMapping("/json")
    @ResponseBody
    public List<TestTask> queryAll(TestTask testTask) {
        return testTaskService.queryAll(testTask);
    }
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    @ResponseBody
    public TestTask queryById(@PathVariable("id") Integer id) {
        return this.testTaskService.queryById(id);
    }

    /**
     * 新增数据
     *
     * @param testTask 实体
     * @return 新增结果
     */
    @PostMapping
    public String add(TestTask testTask) {
        testTaskService.insert(testTask);
        return "redirect:/testTask";
    }

    /**
     * 编辑数据
     *
     * @param testTask 实体
     * @return 编辑结果
     */
    @PostMapping("/edit")
    public String edit(TestTask testTask) {
        this.testTaskService.update(testTask);
        return "redirect:/testTask";
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @GetMapping("/delete/{id}")
    public String deleteById(@PathVariable Integer id) {
        this.testTaskService.deleteById(id);
        return "redirect:/testTask";
    }

    /**
     * 收藏、取消收藏接口
     */
    @GetMapping("/collect/{id}")
    public String collectById(@PathVariable Integer id) {
        this.testTaskService.collectTask(id);
        return "redirect:/testTask";
    }

    /**
     * 开始任务
     *
     * @param id
     * @return
     */
    @GetMapping("/start/{id}")
    public String start(@PathVariable Integer id) {
        this.testTaskService.startTestTask(id);
        return "redirect:/testTask";
    }

    /**
     * 结束任务
     *
     * @param id
     * @return
     */
    @GetMapping("/stop/{id}")
    public String stop(@PathVariable Integer id) {
        this.testTaskService.stopTestTask(id);
        return "redirect:/testTask";
    }
}

