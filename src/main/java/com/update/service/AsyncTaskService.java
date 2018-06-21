package com.update.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import static java.lang.Thread.sleep;

/**
 * Created by LiNan on 2018-06-20.
 * Description:
 */
@Service
public class AsyncTaskService{

    @Async
    public void executeAsyncTask(int i){
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("执行异步任务: " + i);
    }


    public void executeAsyncTaskPlus(int i){
        System.out.println("执行同步任务: " + (i+1));
    }


}
