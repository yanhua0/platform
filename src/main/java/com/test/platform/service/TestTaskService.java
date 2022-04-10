package com.test.platform.service;

import com.test.platform.entity.TestTask;

import java.util.List;

/**
 * (TestTask)表服务接口
 *
 * @since 2022-04-09 13:39:09
 */
public interface TestTaskService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TestTask queryById(Integer id);

    /**
     * 查询
     *
     * @param testTask 筛选条件
     * @return 查询结果
     */
    List<TestTask> queryAll(TestTask testTask);

    /**
     * 新增数据
     *
     * @param testTask 实例对象
     * @return 实例对象
     */
    TestTask insert(TestTask testTask);

    /**
     * 修改数据
     *
     * @param testTask 实例对象
     * @return 实例对象
     */
    void update(TestTask testTask);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    void deleteById(Integer id);

    /**
     * 收藏、取消收藏接口
     *
     * @param id
     */
    void collectTask(Integer id);

    /**
     * 任务启动
     */
    void startTestTask(Integer id);

    /**
     * 任务暂停
     */
    void stopTestTask(Integer id);

}
