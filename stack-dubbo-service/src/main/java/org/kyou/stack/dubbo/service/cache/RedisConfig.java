package org.kyou.stack.dubbo.service.cache;

public class RedisConfig {
    private String address;
    private Integer timeout;
    private Integer maxRedirections;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getTimeout() {
        return timeout;
    }

    public void setTimeout(Integer timeout) {
        this.timeout = timeout;
    }

    public Integer getMaxRedirections() {
        return maxRedirections;
    }

    public void setMaxRedirections(Integer maxRedirections) {
        this.maxRedirections = maxRedirections;
    }
}
