package org.demo.springbootmybatis.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 用户测试线程
 * Created by zhaol on 2018/8/10.
 */
public class UserThread implements Runnable {

    private static Logger logger = LoggerFactory.getLogger(UserThread.class);

    //用户线程运行状态
    private boolean runstate = true;

    @Override
    public void run() {
        while(runstate) {
            try {
                logger.info("UserThread正在执行中......");
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                logger.error("UserThread被中断了", e);
            }
        }

        logger.info("UserThread停止了");

    }

    public boolean shutdown() {
        logger.info("UserThread正在被停止");
        if(runstate) this.runstate = false;
        logger.info("UserThread停止完成");
        return true;
    }

}
