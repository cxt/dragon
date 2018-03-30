package com.cxt;

/**
 * author Administrator
 * date   2018/3/9
 */
public class Test {
    public static int say1(){
        int i = 1;
        return i++;
    }

    public int say2(){
        int i = 1;
        return i++;
    }
    public static void main(String[] args) {
        Test.say1();

        Test test1 = new Test();
        test1.say2();

        Test test2 = new Test();
        test2.say2();
    }

}
