package com.zhaocm.test.thread;

import java.util.Date;
import java.util.concurrent.Callable;

/**
 * @Author zhaocm
 * @Description 有返回值的线程
 * @Date 2020/12/10
 **/
public class Demo3 {


    class MyCallable implements Callable<Object> {
        private String taskNum;

        MyCallable(String taskNum) {
            this.taskNum = taskNum;
        }

        @Override
        public Object call() throws Exception {
            System.out.println(">>>>" + taskNum + "任务启动");
            Date date1 = new Date();
            Thread.sleep(1000);
            Date date2 = new Date();
            long time = date2.getTime() - date1.getTime();
            System.out.println(">>>>>" + taskNum + "任务终止");
            return taskNum + "任务返回运行结果，当前任务时间【" + time + "毫秒】";
        }
    }
}
