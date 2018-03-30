package com.cxt.util;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * author Administrator
 * date   2018/3/29
 */
public class KryoUtilTest {
    @Test
    public void writeToByteArray() throws Exception {
        User user = new User();
        user.setAge(12);
        user.setName("cxt");
        byte[] bytes = KryoUtil.writeToByteArray(user);
        System.out.println(bytes.length);
    }

    @Test
    public void readFromByteArray() throws Exception {
        User user = new User();
        user.setAge(12);
        user.setName("cxt");
        byte[] bytes = KryoUtil.writeToByteArray(user);
        User user2 = KryoUtil.readFromByteArray(bytes);
        System.out.println(user2.getName());
    }

}