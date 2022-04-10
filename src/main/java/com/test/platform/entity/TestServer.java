package com.test.platform.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 服务器配置信息表(TestServer)实体类
 * @since 2022-04-09 13:39:09
 */
@Table(name = "test_server")
@Getter
@Setter
public class TestServer{
    /**
     * 主键
     */    
    @Column(name = "id")
    @Id
    private Integer id;
    /**
     * 服务器名称
     */    
    @Column(name = "device_name")
    private String deviceName;
    /**
     * ip
     */    
    @Column(name = "ip")
    private String ip;
    /**
     * 服务器状态
     */    
    @Column(name = "server_status")
    private String serverStatus;
    /**
     * 操作系统
     */    
    @Column(name = "os")
    private String os;
    /**
     * 描述
     */    
    @Column(name = "description")
    private String description;
}

