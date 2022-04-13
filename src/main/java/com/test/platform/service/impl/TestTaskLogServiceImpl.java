package com.test.platform.service.impl;

import com.test.platform.dao.TestTaskLogDao;
import com.test.platform.dto.TestStaticsDTO;
import com.test.platform.dto.TestStaticsResDTO;
import com.test.platform.entity.TestTaskLog;
import com.test.platform.service.TestTaskLogService;
import com.test.platform.utils.ExampleUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * (TestTaskLog)表服务实现类
 *
 * @since 2022-04-09 13:39:09
 */
@Service("testTaskLogService")
public class TestTaskLogServiceImpl implements TestTaskLogService {
    @Resource
    private TestTaskLogDao testTaskLogDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TestTaskLog queryById(Integer id) {
        return this.testTaskLogDao.selectByPrimaryKey(id);
    }

    /**
     * 查询
     *
     * @param testTaskLog 筛选条件
     * @return 查询结果
     */
    @Override
    public List<TestTaskLog> queryAll(TestTaskLog testTaskLog) {
        return this.testTaskLogDao.selectByExample(ExampleUtils.getExample(testTaskLog));
    }

    /**
     * 新增数据
     *
     * @param testTaskLog 实例对象
     * @return 实例对象
     */
    @Override
    public TestTaskLog insert(TestTaskLog testTaskLog) {
        this.testTaskLogDao.insert(testTaskLog);
        return testTaskLog;
    }

    /**
     * 修改数据
     *
     * @param testTaskLog 实例对象
     * @return 实例对象
     */
    @Override
    public void update(TestTaskLog testTaskLog) {
        testTaskLogDao.updateByPrimaryKeySelective(testTaskLog);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public void deleteById(Integer id) {
        testTaskLogDao.deleteByPrimaryKey(id);
    }

    /**
     * 统计
     *
     * @return
     */
    @Override
    public TestStaticsResDTO statics() {
        List<TestStaticsDTO> list = testTaskLogDao.staticsCount();
        Map<String, List<TestStaticsDTO>> testMap = list.stream().collect(Collectors.groupingBy(TestStaticsDTO::getTaskName));
        TestStaticsResDTO testStaticsResDTO = new TestStaticsResDTO();
        testMap.forEach((name, test) -> {
            Map<String, Integer> result = test.stream().collect(Collectors.toMap(TestStaticsDTO::getTaskStatus, TestStaticsDTO::getCount));
            testStaticsResDTO.getTaskName().add(name);
            Integer success = result.get("成功");
            Integer fail = result.get("失败");
            if (success == null) {
                success = 0;
            }
            if (fail == null) {
                fail = 0;
            }
            testStaticsResDTO.getFailCount().add(fail);
            testStaticsResDTO.getSuccessCount().add(success);
        });
        return testStaticsResDTO;
    }
}
