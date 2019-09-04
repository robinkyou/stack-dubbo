package org.kyou.stack.dubbo.service.cache;

public interface CacheService {

    String get(String key);

    String set(String key, String value);

    Long del(String key);
}
