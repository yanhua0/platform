package com.test.platform.service.impl;

import com.test.platform.entity.TestTask;
import com.test.platform.dao.TestTaskDao;
import com.test.platform.service.TestTaskService;
import org.springframework.stereotype.Service;
import java.util.List;
import com.test.platform.utils.ExampleUtils;
import javax.annotation.Resource;

/**
 * (TestTask)表服务实现类
 * @since 2022-04-09 13:39:09
 */
@Service("testTaskService")
public class TestTaskServiceImpl implements TestTaskService {
    @Resource
    private TestTaskDao testTaskDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TestTask queryById(Integer id) {
        return this.testTaskDao.selectByPrimaryKey(id);
    }

    /**
     *查询
     * @param testTask 筛选条件
     * @return 查询结果
     */
    @Override
    public List<TestTask> queryAll(TestTask testTask) {
        return this.testTaskDao.selectByExample(ExampleUtils.getExample(testTask));
    }

    /**
     * 新增数据
     *
     * @param testTask 实例对象
     * @return 实例对象
     */
    @Override
    public TestTask insert(TestTask testTask) {
        this.testTaskDao.insert(testTask);
        return testTask;
    }

    /**
     * 修改数据
     *
     * @param testTask 实例对象
     * @return 实例对象
     */
    @Override
    public void update(TestTask testTask) {
        testTaskDao.updateByPrimaryKeySelective(testTask);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public void deleteById(Integer id) {
       testTaskDao.deleteByPrimaryKey(id);
    }
}
