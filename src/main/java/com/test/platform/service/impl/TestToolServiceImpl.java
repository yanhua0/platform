package com.test.platform.service.impl;

import com.test.platform.dao.TestToolDao;
import com.test.platform.entity.TestTool;
import com.test.platform.service.TestToolService;
import com.test.platform.utils.ExampleUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TestTool)表服务实现类
 * @since 2022-04-09 13:39:09
 */
@Service("testToolService")
public class TestToolServiceImpl implements TestToolService {
    @Resource
    private TestToolDao testToolDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TestTool queryById(Integer id) {
        return this.testToolDao.selectByPrimaryKey(id);
    }

    /**
     *查询
     * @param testTool 筛选条件
     * @return 查询结果
     */
    @Override
    public List<TestTool> queryAll(TestTool testTool) {
        return this.testToolDao.selectByExample(ExampleUtils.getExample(testTool));
    }

    /**
     * 新增数据
     *
     * @param testTool 实例对象
     * @return 实例对象
     */
    @Override
    public TestTool insert(TestTool testTool) {
        this.testToolDao.insert(testTool);
        return testTool;
    }

    /**
     * 修改数据
     *
     * @param testTool 实例对象
     * @return 实例对象
     */
    @Override
    public void update(TestTool testTool) {
        testToolDao.updateByPrimaryKeySelective(testTool);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public void deleteById(Integer id) {
       testToolDao.deleteByPrimaryKey(id);
    }
}
