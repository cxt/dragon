package com.cxt;


import com.google.common.hash.Hashing;
import org.junit.*;

/**
 * author Administrator
 * date   2018/3/13
 */
public class ConsistentHashingTest {
    @org.junit.Test
    public void test(){
        System.out.println(Hashing.consistentHash(123224442L, 5));
    }
}
