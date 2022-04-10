package com.test.platform.service;

import com.test.platform.entity.TestServer;
import java.util.List;

/**
 * 服务器配置信息表(TestServer)表服务接口
 * @since 2022-04-09 13:39:09
 */
public interface TestServerService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TestServer queryById(Integer id);

    /**
     *查询
     * @param testServer 筛选条件
     * @return 查询结果
     */
    List<TestServer> queryAll(TestServer testServer);

    /**
     * 新增数据
     *
     * @param testServer 实例对象
     * @return 实例对象
     */
    TestServer insert(TestServer testServer);

    /**
     * 修改数据
     *
     * @param testServer 实例对象
     * @return 实例对象
     */
    void update(TestServer testServer);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    void deleteById(Integer id);

}
