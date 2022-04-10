package com.test.platform.entity;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.Column;
import javax.persistence.Table;

/**
 * (TestTool)实体类
 * @since 2022-04-09 13:39:09
 */
@Table(name = "test_tool")
@Getter
@Setter
public class TestTool{
    /**
     * 主键
     */    
    @Column(name = "id")
    private Integer id;
    /**
     * 工具名称
     */    
    @Column(name = "tool_name")
    private String toolName;
    /**
     * 创建时间
     */    
    @Column(name = "description")
    private String description;
    /**
     * 创建时间
     */    
    @Column(name = "create_time")
    private Date createTime;
}

