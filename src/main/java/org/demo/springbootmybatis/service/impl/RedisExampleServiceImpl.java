package org.demo.springbootmybatis.service.impl;

import org.demo.springbootmybatis.service.RedisExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by zhaol on 2018/5/2.
 */
@Service
public class RedisExampleServiceImpl implements RedisExampleService {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public void save() {
        ValueOperations<String, Object> valueOps = redisTemplate.opsForValue();
        ListOperations<String, Object> listOps = redisTemplate.opsForList();
        SetOperations<String, Object> setOps = redisTemplate.opsForSet();
        ZSetOperations<String, Object> zSetOps = redisTemplate.opsForZSet();
        HashOperations<String, String, Object> hashOps = redisTemplate.opsForHash();

        //valueOps.set("key","value");
        //valueOps.get("key");

        //listOps.leftPush("key", "leftValue");
        //listOps.leftPushAll("key", "leftValue1", "leftValue2");
        //listOps.rightPush("key", "rightValue");
        //listOps.rightPushAll("key", "rightValue1", "rightValue2");
        //获取指定key的范围内的value值的 list列表（0 -1）反回所有值列表
        //List<Object> list = listOps.range("key", 0, listOps.size("key"));
        //移除列表左边的第一个值
        //listOps.leftPop("key");
        //移除列表右边的第一个值
        //listOps.rightPop("key");

        //为散列添加或者覆盖一个hashKey-hashValue键值对
        hashOps.put("key", "hashKey", "hashValue");
        //为散列添加多个key-value键值对
        Map<String, String> map = new HashMap<>();
        map.put("hashKey1", "hashValue1");
        map.put("hashKey2", "hashValue2");
        map.put("hashKey3", "hashValue3");
        hashOps.putAll("key", map);
        //获取散列的value集合
        List<Object> valueList = hashOps.values("key");
        for (Object obj : valueList) {
            System.out.println(obj);
        }
        System.out.println("#####################################");
        //获取散列的key-value键值对集合
        Map<String, Object> hashMap = hashOps.entries("key");
        Set<String> hashKey = hashMap.keySet();
        for (String key: hashKey) {
            System.out.println("hashKey:"+key+" hashValue: "+hashMap.get(key));
        }
        System.out.println("#####################################");
        //得到某个散列中hashKey的hashValue值
        String hashValue = (String) hashOps.get("key", "hashKey");
        System.out.println("hashKey-->hashValue: "+hashValue);

        /*
        * 第二组API只是在第一组API的上面将key值的绑定放在获得接口时了，此举方便了每次操作
        * 基本数据类型的时候不用反复的去填写key值，只需要操作具体的value就行了。
        * */
        BoundValueOperations<String, Object> boundValueOps = redisTemplate.boundValueOps("key");
        BoundListOperations<String, Object> boundListOps = redisTemplate.boundListOps("key");
        BoundSetOperations<String, Object> boundSetOps = redisTemplate.boundSetOps("key");
        BoundZSetOperations<String, Object> boundZSetOps = redisTemplate.boundZSetOps("key");
        BoundHashOperations<String, Object, Object> boundHashOps = redisTemplate.boundHashOps("key");
    }

    @Override
    public String show() {
        return redisTemplate.opsForValue().get("test").toString();
    }

    @Override
    public void trim() {
        ListOperations<String, Object> listOps = redisTemplate.opsForList();
        //System.out.println(listOps.size("key"));
        //listOps.trim("key", 0, 0);
        //listOps.rightPop("key");
        //listOps.leftPop("key");
    }
}
