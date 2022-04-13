package com.test.platform.service;

import com.test.platform.dto.TestStaticsResDTO;
import com.test.platform.entity.TestTaskLog;
import java.util.List;

/**
 * (TestTaskLog)表服务接口
 * @since 2022-04-09 13:39:09
 */
public interface TestTaskLogService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TestTaskLog queryById(Integer id);

    /**
     *查询
     * @param testTaskLog 筛选条件
     * @return 查询结果
     */
    List<TestTaskLog> queryAll(TestTaskLog testTaskLog);

    /**
     * 新增数据
     *
     * @param testTaskLog 实例对象
     * @return 实例对象
     */
    TestTaskLog insert(TestTaskLog testTaskLog);

    /**
     * 修改数据
     *
     * @param testTaskLog 实例对象
     * @return 实例对象
     */
    void update(TestTaskLog testTaskLog);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    void deleteById(Integer id);

    /**
     * 统计
     * @return
     */
    TestStaticsResDTO statics();
}
