package com.test.platform.service.impl;

import com.test.platform.dao.TestTaskDao;
import com.test.platform.entity.TestTask;
import com.test.platform.service.TestTaskLogService;
import com.test.platform.service.TestTaskService;
import com.test.platform.thread.TaskThread;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * (TestTask)表服务实现类
 *
 * @since 2022-04-09 13:39:09
 */
@Service("testTaskService")
@Slf4j
public class TestTaskServiceImpl implements TestTaskService {
    @Resource
    private TestTaskDao testTaskDao;
    @Resource
    private TestTaskLogService testTaskLogService;

    public static Map<Integer, TaskThread> TASK_THREAD = new ConcurrentHashMap<>();

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
     * 查询
     *
     * @param testTask 筛选条件
     * @return 查询结果
     */
    @Override
    public List<TestTask> queryAll(TestTask testTask) {
        Example example = new Example(testTask.getClass());
        Example.Criteria criteria = example.createCriteria();
        if (!StringUtils.isEmpty(testTask.getTaskName()))
            criteria.andLike("taskName", "%" + testTask.getTaskName() + "%");
        if (testTask.getCollectStatus() != null)
            criteria.andEqualTo("collectStatus", testTask.getCollectStatus());
        if (!StringUtils.isEmpty(testTask.getTaskStatus()))
            criteria.andEqualTo("taskStatus", testTask.getTaskStatus());
        return this.testTaskDao.selectByExample(example);
    }

    /**
     * 新增数据
     *
     * @param testTask 实例对象
     * @return 实例对象
     */
    @Override
    public TestTask insert(TestTask testTask) {
        testTask.setCreateTime(new Date());
        testTask.setCollectStatus(0);
        testTask.setTaskStatus("就绪");
        testTaskDao.insert(testTask);
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

    @Override
    public void collectTask(Integer id) {
        TestTask testTask = queryById(id);
        if (1 == testTask.getCollectStatus()) {
            testTask.setCollectStatus(0);
        } else {
            testTask.setCollectStatus(1);
        }
        update(testTask);
    }

    @Override
    public void startTestTask(Integer id) {
        TestTask testTask = queryById(id);
        log.info("创建任务id={}", id);
        TaskThread thread = new TaskThread(testTask, this, testTaskLogService);
        TASK_THREAD.put(id, thread);
        log.info("任务id={}开始执行", id);
        thread.start();
    }

    @Override
    public void stopTestTask(Integer id) {
        TaskThread thread = TASK_THREAD.get(id);
        if (thread != null) {
            log.info("任务id={}停止执行", id);
            thread.stop();
        }
    }
}
