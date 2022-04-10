package com.test.platform.service;

import com.test.platform.entity.TestTool;
import java.util.List;

/**
 * (TestTool)表服务接口
 * @since 2022-04-09 13:39:09
 */
public interface TestToolService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TestTool queryById(Integer id);

    /**
     *查询
     * @param testTool 筛选条件
     * @return 查询结果
     */
    List<TestTool> queryAll(TestTool testTool);

    /**
     * 新增数据
     *
     * @param testTool 实例对象
     * @return 实例对象
     */
    TestTool insert(TestTool testTool);

    /**
     * 修改数据
     *
     * @param testTool 实例对象
     * @return 实例对象
     */
    void update(TestTool testTool);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    void deleteById(Integer id);

}
