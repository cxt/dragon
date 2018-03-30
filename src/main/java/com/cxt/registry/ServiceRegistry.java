package com.cxt.registry;

/**
 * Created by Administrator on 2018/1/22.
 */
public interface ServiceRegistry {
    /**
     *
     * @param serviceName
     * @param serviceAddress
     */
    void register(String serviceName, String serviceAddress);
}
