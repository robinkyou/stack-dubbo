package org.kyou.stack.dubbo.service.cache;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;
import java.util.Set;

public class RedisClusterFactory implements FactoryBean<JedisCluster>, InitializingBean {
    private RedisConfig redisConfig;
    private JedisCluster jedisCluster;
    private GenericObjectPoolConfig genericObjectPoolConfig;

    @Override
    public JedisCluster getObject(){
        return jedisCluster;
    }

    @Override
    public Class<? extends JedisCluster> getObjectType() {
        return (this.jedisCluster != null ? this.jedisCluster.getClass() : JedisCluster.class);
    }

    private Set<HostAndPort> parseHostAndPort() throws Exception {
        Set<HostAndPort> hostSet = new HashSet<>();
        try {

            String address = this.redisConfig.getAddress();
            if (StringUtils.isBlank(address)) {
                return hostSet;
            }
            String[] addresses = StringUtils.split(address, ",");
            if (addresses == null || addresses.length == 0) {
                return hostSet;
            }
            for (String host : addresses) {
                String[] ipAndPort = host.split(":");
                HostAndPort hap = new HostAndPort(ipAndPort[0], Integer.parseInt(ipAndPort[1]));
                hostSet.add(hap);
            }

            return hostSet;
        } catch (IllegalArgumentException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new Exception("解析 jedis 配置文件失败", ex);
        }
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Set<HostAndPort> hostSet = this.parseHostAndPort();
        jedisCluster = new JedisCluster(hostSet, this.redisConfig.getTimeout(), this.redisConfig.getMaxRedirections(), genericObjectPoolConfig);

    }

    public RedisConfig getRedisConfig() {
        return redisConfig;
    }

    public void setRedisConfig(RedisConfig redisConfig) {
        this.redisConfig = redisConfig;
    }

    public GenericObjectPoolConfig getGenericObjectPoolConfig() {
        return genericObjectPoolConfig;
    }

    public void setGenericObjectPoolConfig(GenericObjectPoolConfig genericObjectPoolConfig) {
        this.genericObjectPoolConfig = genericObjectPoolConfig;
    }
}