package com.test.platform.controller;

import com.test.platform.entity.TestTaskLog;
import com.test.platform.service.TestTaskLogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TestTaskLog)表控制层
 * @since 2022-04-09 13:39:09
 */
@RestController
@RequestMapping("testTaskLog")
public class TestTaskLogController {
    /**
     * 服务对象
     */
    @Resource
    private TestTaskLogService testTaskLogService;

    /**
     * 查询
     * @param testTaskLog 筛选条件
     * @return 查询结果
     */
    @GetMapping
    public List<TestTaskLog> queryAll(TestTaskLog testTaskLog) {
        return testTaskLogService.queryAll(testTaskLog);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public TestTaskLog queryById(@PathVariable("id") Integer id) {
        return this.testTaskLogService.queryById(id);
    }

    /**
     * 新增数据
     *
     * @param testTaskLog 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<TestTaskLog> add(TestTaskLog testTaskLog) {
        return ResponseEntity.ok(this.testTaskLogService.insert(testTaskLog));
    }

    /**
     * 编辑数据
     *
     * @param testTaskLog 实体
     * @return 编辑结果
     */
    @PutMapping
    public void edit(TestTaskLog testTaskLog) {
        this.testTaskLogService.update(testTaskLog);
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public void deleteById(Integer id) {
        this.testTaskLogService.deleteById(id);
    }

}
