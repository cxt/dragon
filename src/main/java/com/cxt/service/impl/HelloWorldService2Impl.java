package com.cxt.service.impl;

import com.cxt.server.RpcService;
import com.cxt.service.HelloWorldService;

/**
 * @author Administrator
 * @date   2018/3/30
 */
@RpcService(value = HelloWorldService.class,version = "helloworld2")
public class HelloWorldService2Impl implements HelloWorldService {
    @Override
    public String hello(String name) {
        return "hello2 : cao " + name;
    }
}
