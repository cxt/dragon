package com.cxt.registry.impl;

import com.cxt.common.Constants;
import com.cxt.registry.ServiceDiscover;
import io.netty.util.internal.ThreadLocalRandom;
import org.I0Itec.zkclient.ZkClient;

import java.util.List;

/**
 * zk service discover
 * @author Administrator
 * @date 2018/1/23
 */
public class ZookeeperDiscover implements ServiceDiscover {
    private final ZkClient zkClient;

    /**
     *
     * @param zkAddress  zookeeper地址
     */
    public ZookeeperDiscover(String zkAddress) {
       /* create a  zk client */
        zkClient = new ZkClient(zkAddress, Constants.ZK_SESSION_TIMEOUT,Constants.ZK_CONNECTION_TIMEOUT);
    }

    @Override
    public String discover(String serviceName) {
        try {
            String servicePath = Constants.ZK_REGISTRY_PATH + "/" + serviceName;
            List<String> children = zkClient.getChildren(servicePath);
            if (null == children || children.size() <= 0){
                throw new RuntimeException("not has " + serviceName);
            }

            String address;

            if(children.size() == 1) {
                address = children.get(0);
            }else {
                address = children.get(ThreadLocalRandom.current().nextInt(children.size()));
            }

            for (String str: children) {
                System.out.println(str);
            }

            String addressPath = servicePath + "/" + address;

            return zkClient.readData(addressPath);
        }finally {
            zkClient.close();
        }
    }
}
