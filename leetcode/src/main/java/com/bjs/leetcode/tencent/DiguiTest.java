package com.bjs.leetcode.tencent;

public class DiguiTest {

    public static void main(String[] args) {
        int result = sum(100);
        System.out.println(result);
    }


    public static int sum(int n ){
        if(n>0){
            return n+ sum(n-1);
        }
        return 0;
    }
}
