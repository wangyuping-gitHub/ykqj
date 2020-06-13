package com.wyp.spring.cloud.test;

import org.junit.Test;

public class TestApp {
    @Test
    public void test(){
        String str = "java";
        String str1 = "ja" + new String("va");
        System.out.println(str == str1);
    }

}
