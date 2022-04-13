package com.test.platform.thread;

import com.test.platform.dto.RestResult;
import com.test.platform.entity.TestTask;
import com.test.platform.entity.TestTaskLog;
import com.test.platform.service.TestTaskLogService;
import com.test.platform.service.TestTaskService;
import com.test.platform.service.impl.TestTaskServiceImpl;
import com.test.platform.utils.RpcUtils;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.Objects;

/**
 * 任务启动线程
 */
@Getter
@Setter
@Slf4j
public class TaskThread extends Thread {
    private TestTask testTask;


    private TestTaskService testTaskService;

    private TestTaskLogService testTaskLogService;

    public TaskThread(TestTask testTask, TestTaskService testTaskService, TestTaskLogService testTaskLogService) {
        this.testTask = testTask;
        this.testTaskService = testTaskService;
        this.testTaskLogService = testTaskLogService;
        this.setName("thread-" + testTask.getTaskName());
    }

    @Override
    public void run() {
        if (Objects.nonNull(testTask.getWaitTime())) {
            try {
                log.info("sleep {} s", testTask.getWaitTime());
                Thread.sleep(testTask.getWaitTime() * 1000);
            } catch (InterruptedException e) {
                log.error("线程异常", e);
            }
        }
        String requestUrl = testTask.getRequestUrl();
        String method = testTask.getRequestMethod();
        String reqBody = testTask.getRequestBody();
        RestResult restResult = RpcUtils.getRes(requestUrl, method, reqBody);
        TestTaskLog testTaskLog = new TestTaskLog();
        testTaskLog.setTaskId(testTask.getId().toString());
        testTaskLog.setTaskName(testTask.getTaskName());
        testTaskLog.setTaskDesc(testTask.getDescription());
        testTaskLog.setExecuteResult(restResult.getResultMsg());
        testTaskLog.setResult(restResult.getResult());
        testTaskLog.setCreateTime(new Date());
        testTask.setTaskStatus(restResult.getResultMsg());
        //更新任务的状态
        testTaskService.update(testTask);
        //保存任务执行日志
        testTaskLogService.insert(testTaskLog);
        //移除
        TestTaskServiceImpl.TASK_THREAD.remove(testTask.getId());
    }
}
