package xyz.ilovectrl.order.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * redis分布式锁的用法
 */
@Component
@Slf4j
public class RedisLock {

    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * 加锁
     * @param key
     * @param value 当前时间+超时时间
     * @return
     */
    public boolean lock(String key,String value){
        //setIfAbsent表示key不存在才设置value(即加锁),如果存在则返回false(即锁被占有)
        if (redisTemplate.opsForValue().setIfAbsent(key,value)){
            //表示加锁成功
            return true;
        }
        String currentValue=redisTemplate.opsForValue().get(key);
        //如果锁过期(防止长时间占有锁)
        if (!StringUtils.isEmpty(currentValue)
                &&Long.parseLong(currentValue)<System.currentTimeMillis()){
            //当多线程同时获取值时，只会有其中一个线程可以进行加锁操作
            String oldValue=redisTemplate.opsForValue().getAndSet(key,value);
            if (!StringUtils.isEmpty(oldValue)&&oldValue.equals(currentValue)){
                return true;
            }
        }
        //表示锁已经被占用
        return false;
    }

    /**
     * 解锁
     */
    public void unlock(String key,String value){
        try {
            String currentValue=redisTemplate.opsForValue().get(key);
            if (!StringUtils.isEmpty(currentValue)&&currentValue.equals(value)){
                redisTemplate.opsForValue().getOperations().delete(key);
            }
        }catch (Exception e){
            log.error("【redis分布式锁】解锁异常,{}",e);
        }
    }
}
