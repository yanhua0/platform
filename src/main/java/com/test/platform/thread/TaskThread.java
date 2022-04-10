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

import java.util.Date;

/**
 * 任务启动线程
 */
@Getter
@Setter
public class TaskThread extends Thread {
    private TestTask testTask;


    private TestTaskService testTaskService;

    private TestTaskLogService testTaskLogService;

    public TaskThread(TestTask testTask, TestTaskService testTaskService,TestTaskLogService testTaskLogService) {
        this.testTask = testTask;
        this.testTaskService=testTaskService;
        this.testTaskLogService=testTaskLogService;
    }

    @Override
    public void run() {
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
