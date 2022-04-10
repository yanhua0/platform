package com.test.platform.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * (TestTaskLog)实体类
 * @since 2022-04-09 13:39:09
 */
@Table(name = "test_task_log")
@Getter
@Setter
public class TestTaskLog{
    /**
     * 主键
     */    
    @Column(name = "id")
    @Id
    private Integer id;
    /**
     * 任务id
     */    
    @Column(name = "task_id")
    private String taskId;
    /**
     * 任务名称
     */    
    @Column(name = "task_name")
    private String taskName;
    /**
     * 任务描述
     */    
    @Column(name = "task_desc")
    private String taskDesc;
    /**
     * 成功，失败
     */    
    @Column(name = "execute_result")
    private String executeResult;
    /**
     * 接口返回结果
     */    
    @Column(name = "result")
    private String result;
    /**
     * 创建时间
     */    
    @Column(name = "create_time")
    private Date createTime;
}

