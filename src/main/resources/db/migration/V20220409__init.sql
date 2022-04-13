DROP TABLE IF EXISTS test_tool;
CREATE TABLE test_tool(
                          id INT(11) NOT NULL AUTO_INCREMENT  COMMENT '主键' ,
                          tool_name VARCHAR(32)    COMMENT '工具名称' ,
                          description VARCHAR(255)    COMMENT '创建时间' ,
                          create_time DATETIME    COMMENT '创建时间' ,
                          PRIMARY KEY (id)
)  COMMENT = '';

DROP TABLE IF EXISTS test_server;
CREATE TABLE test_server(
                            id INT(11) NOT NULL AUTO_INCREMENT  COMMENT '主键' ,
                            device_name VARCHAR(200)    COMMENT '服务器名称' ,
                            ip VARCHAR(200)    COMMENT 'ip' ,
                            server_status VARCHAR(200)    COMMENT '服务器状态' ,
                            os VARCHAR(200)    COMMENT '操作系统' ,
                            description VARCHAR(100)    COMMENT '描述' ,
                            PRIMARY KEY (id)
)  COMMENT = '服务器配置信息表';




DROP TABLE IF EXISTS test_task;
CREATE TABLE test_task(
                          id INT(11) NOT NULL AUTO_INCREMENT  COMMENT '主键' ,
                          task_name VARCHAR(32)    COMMENT '任务名称' ,
                          task_status VARCHAR(11)    COMMENT '任务状态，完成，就绪' ,
                          collect_status INT(11)    COMMENT '收藏状态，0--未收藏，1--收藏' ,
                          description VARCHAR(255)    COMMENT '描述' ,
                          create_time DATETIME    COMMENT '创建时间' ,
                          wait_time INT(11)    COMMENT '等待时间' ,
                          request_url VARCHAR(255)    COMMENT '请求url' ,
                          request_method VARCHAR(255)    COMMENT '请求方法' ,
                          request_body VARCHAR(255)    COMMENT '请求参数' ,
                          PRIMARY KEY (id)
)  COMMENT = '';

DROP TABLE IF EXISTS test_task_log;
CREATE TABLE test_task_log(
                              id INT(11) NOT NULL AUTO_INCREMENT  COMMENT '主键' ,
                              task_id VARCHAR(32)    COMMENT '任务id' ,
                              task_name VARCHAR(255)    COMMENT '任务名称' ,
                              task_desc VARCHAR(255)    COMMENT '任务描述' ,
                              execute_result VARCHAR(20)    COMMENT '成功，失败' ,
                              result text    COMMENT '接口返回结果' ,
                              create_time DATETIME    COMMENT '创建时间' ,
                              PRIMARY KEY (id)
)  COMMENT = '';

