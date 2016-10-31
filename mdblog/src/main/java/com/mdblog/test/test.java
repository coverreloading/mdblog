package com.mdblog.test;

import org.testng.annotations.Test;

/**
 * Created by Vincent on 16/10/31.
 */
public class test {
    @Test
    public void test(){
        String str="        56.澳大利亚  昆士兰 鸟瞰大堡礁\n";
        str=str.trim();
        System.out.println(str);
        String[] str2=str.split("\\.");
        System.out.println(str2[0]);
    }
}
