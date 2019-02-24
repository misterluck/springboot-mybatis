package org.demo.springbootmybatis.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by zhaol on 2018/8/10.
 */
@Component
public class MonitorManagerTask {
    private static Logger logger = LoggerFactory.getLogger(MonitorManagerTask.class);

    private ConcurrentHashMap<String, UserThread> map = new ConcurrentHashMap<String, UserThread>();

    private ExecutorService esUser = Executors.newCachedThreadPool();

    public void startUserThread() {
        String uuid = UUID.randomUUID().toString();
        UserThread userThread = new UserThread();
        //esUser.submit(userThread);
        esUser.execute(userThread);
        map.put(uuid, userThread);
        logger.info("uuid:"+uuid);
    }

    public void stopUserThread(String uuid) {
        if (map.containsKey(uuid)) {
            UserThread userThread = map.get(uuid);
            userThread.shutdown();
            map.remove(uuid);
        } else {
            logger.info("不存在key");
        }
    }

}
