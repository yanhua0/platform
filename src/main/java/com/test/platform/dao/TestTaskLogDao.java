package com.test.platform.dao;

import com.test.platform.dto.TestStaticsDTO;
import com.test.platform.entity.TestTaskLog;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * (TestTaskLog)表数据库访问层
 *
 * @author makejava
 * @since 2022-04-09 13:39:09
 */
public interface TestTaskLogDao extends Mapper<TestTaskLog> {
    List<TestStaticsDTO> staticsCount();
}

