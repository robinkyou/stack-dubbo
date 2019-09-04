package org.kyou.stack.dubbo.service.cache.impl;

import org.kyou.stack.dubbo.service.cache.CacheService;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;

import javax.annotation.Resource;
@Service
public class CacheServiceImpl implements CacheService {

    @Resource
    private JedisCluster jedisCluster;

    @Override
    public String get(String key) {
        return jedisCluster.get(key);
    }

    @Override
    public String set(String key, String value) {
        return jedisCluster.set(key, value);
    }

    @Override
    public Long del(String key) {
        return jedisCluster.del(key);
    }
}
