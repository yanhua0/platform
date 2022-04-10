package com.test.platform.service.impl;

import com.test.platform.dao.TestServerDao;
import com.test.platform.entity.TestServer;
import com.test.platform.service.TestServerService;
import com.test.platform.utils.ExampleUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 服务器配置信息表(TestServer)表服务实现类
 * @since 2022-04-09 13:39:09
 */
@Service("testServerService")
public class TestServerServiceImpl implements TestServerService {
    @Resource
    private TestServerDao testServerDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TestServer queryById(Integer id) {
        return this.testServerDao.selectByPrimaryKey(id);
    }

    /**
     *查询
     * @param testServer 筛选条件
     * @return 查询结果
     */
    @Override
    public List<TestServer> queryAll(TestServer testServer) {
        return this.testServerDao.selectByExample(ExampleUtils.getExample(testServer));
    }

    /**
     * 新增数据
     *
     * @param testServer 实例对象
     * @return 实例对象
     */
    @Override
    public TestServer insert(TestServer testServer) {
        this.testServerDao.insert(testServer);
        return testServer;
    }

    /**
     * 修改数据
     *
     * @param testServer 实例对象
     * @return 实例对象
     */
    @Override
    public void update(TestServer testServer) {
        testServerDao.updateByPrimaryKeySelective(testServer);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public void deleteById(Integer id) {
       testServerDao.deleteByPrimaryKey(id);
    }
}
