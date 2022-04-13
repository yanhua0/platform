package com.test.platform.service.impl;

import com.test.platform.dao.UserInfoDao;
import com.test.platform.entity.UserInfo;
import com.test.platform.service.UserInfoService;
import com.test.platform.utils.ExampleUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (UserInfo)表服务实现类
 * @since 2022-04-11 20:41:35
 */
@Service("userInfoService")
public class UserInfoServiceImpl implements UserInfoService {
    @Resource
    private UserInfoDao userInfoDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public UserInfo queryById(Integer id) {
        return this.userInfoDao.selectByPrimaryKey(id);
    }

    /**
     *查询
     * @param userInfo 筛选条件
     * @return 查询结果
     */
    @Override
    public List<UserInfo> queryAll(UserInfo userInfo) {
        return this.userInfoDao.selectByExample(ExampleUtils.getExample(userInfo));
    }

    /**
     * 新增数据
     *
     * @param userInfo 实例对象
     * @return 实例对象
     */
    @Override
    public UserInfo insert(UserInfo userInfo) {
        this.userInfoDao.insert(userInfo);
        return userInfo;
    }

}
