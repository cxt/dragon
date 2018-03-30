package com.cxt.hystrix;

import org.junit.Test;
import rx.Observable;
import rx.Observer;
import rx.functions.Action1;

import java.util.concurrent.Future;

import static org.junit.Assert.*;

/**
 * author Administrator
 * date   2018/1/29
 */
public class HelloWorldCommandTest {
    @Test
    public  void test() throws Exception {
//        HelloWorldCommand command = new HelloWorldCommand("CLKBKB");
//        /* 同步调用 */
//        System.out.println(command.run());
//
//        /* 异步调用 */
//        Future<String> future = command.queue();
//        System.out.println(future.get());

        /* 响应式调用 */
        /* 阻塞调用*/
//        System.out.println(command.observe().toBlocking().single());

        /* 非阻塞调用*/
        /*command.observe().subscribe(new Observer<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onNext(String s) {
                System.out.println(s);
            }
        });*/

        /* 非阻塞调用*/
//        command.observe().subscribe(new Action1<String>() {
//            @Override
//            public void call(String s) {
//                System.out.println(s);
//            }
//        });
    }
}