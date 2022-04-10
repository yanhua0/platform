package com.test.platform.entity;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.Column;
import javax.persistence.Table;

/**
 * (TestTask)实体类
 * @since 2022-04-09 13:39:09
 */
@Table(name = "test_task")
@Getter
@Setter
public class TestTask{
    /**
     * 主键
     */    
    @Column(name = "id")
    private Integer id;
    /**
     * 任务名称
     */    
    @Column(name = "task_name")
    private String taskName;
    /**
     * 任务状态，完成，就绪
     */    
    @Column(name = "task_status")
    private String taskStatus;
    /**
     * 收藏状态，0--未收藏，1--收藏
     */    
    @Column(name = "collect_status")
    private Integer collectStatus;
    /**
     * 描述
     */    
    @Column(name = "description")
    private String description;
    /**
     * 创建时间
     */    
    @Column(name = "create_time")
    private Date createTime;
    /**
     * 请求url
     */    
    @Column(name = "request_url")
    private String requestUrl;
    /**
     * 请求方法
     */    
    @Column(name = "request_method")
    private String requestMethod;
    /**
     * 请求参数
     */    
    @Column(name = "request_body")
    private String requestBody;
}

