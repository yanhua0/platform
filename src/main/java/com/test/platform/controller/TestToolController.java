package com.test.platform.controller;

import com.test.platform.entity.TestTool;
import com.test.platform.service.TestToolService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TestTool)表控制层
 * @since 2022-04-09 13:39:09
 */
@RestController
@RequestMapping("testTool")
public class TestToolController {
    /**
     * 服务对象
     */
    @Resource
    private TestToolService testToolService;

    /**
     * 查询
     * @param testTool 筛选条件
     * @return 查询结果
     */
    @GetMapping
    public List<TestTool> queryAll(TestTool testTool) {
        return testToolService.queryAll(testTool);
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
    public ResponseEntity<TestTool> add(TestTool testTool) {
        return ResponseEntity.ok(this.testToolService.insert(testTool));
    }

    /**
     * 编辑数据
     *
     * @param testTool 实体
     * @return 编辑结果
     */
    @PutMapping
    public void edit(TestTool testTool) {
        this.testToolService.update(testTool);
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public void deleteById(Integer id) {
        this.testToolService.deleteById(id);
    }

}

