package com.test.platform.service;

import com.test.platform.entity.UserInfo;
import java.util.List;

/**
 * (UserInfo)表服务接口
 * @since 2022-04-11 20:41:35
 */
public interface UserInfoService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    UserInfo queryById(Integer id);

    /**
     *查询
     * @param userInfo 筛选条件
     * @return 查询结果
     */
    List<UserInfo> queryAll(UserInfo userInfo);

    /**
     * 新增数据
     *
     * @param userInfo 实例对象
     * @return 实例对象
     */
    UserInfo insert(UserInfo userInfo);

}
