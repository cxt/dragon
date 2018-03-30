package com.cxt.service.impl;

import com.cxt.server.RpcService;
import com.cxt.service.HelloWorldService;

/**
 * @author Administrator
 * @date   2018/3/30
 */
@RpcService(HelloWorldService.class)
public class HelloWorldServiceImpl implements HelloWorldService {
    @Override
    public String hello(String name) {
        return "fuck " + name;
    }
}
