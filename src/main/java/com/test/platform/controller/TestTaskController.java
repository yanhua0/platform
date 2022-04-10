package com.test.platform.controller;

import com.test.platform.entity.TestTask;
import com.test.platform.service.TestTaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TestTask)表控制层
 * @since 2022-04-09 13:39:09
 */
@RestController
@RequestMapping("testTask")
public class TestTaskController {
    /**
     * 服务对象
     */
    @Resource
    private TestTaskService testTaskService;

    /**
     * 查询
     * @param testTask 筛选条件
     * @return 查询结果
     */
    @GetMapping
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
    public ResponseEntity<TestTask> add(TestTask testTask) {
        return ResponseEntity.ok(this.testTaskService.insert(testTask));
    }

    /**
     * 编辑数据
     *
     * @param testTask 实体
     * @return 编辑结果
     */
    @PutMapping
    public void edit(TestTask testTask) {
        this.testTaskService.update(testTask);
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public void deleteById(Integer id) {
        this.testTaskService.deleteById(id);
    }

}

