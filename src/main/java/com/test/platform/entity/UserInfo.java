package com.test.platform.entity;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.Column;
import javax.persistence.Table;

/**
 * (UserInfo)实体类
 * @since 2022-04-11 20:41:35
 */
@Table(name = "user_info")
@Getter
@Setter
public class UserInfo{
    /**
     * 主键
     */    
    @Column(name = "id")
    private Integer id;
    /**
     * 用户名
     */    
    @Column(name = "usercode")
    private String usercode;
    /**
     * 密码
     */    
    @Column(name = "password")
    private String password;
    /**
     * 用户名称
     */    
    @Column(name = "username")
    private String username;
}

