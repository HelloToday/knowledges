package com.bjs.leetcode.tencent;

import com.sun.deploy.util.StringUtils;

import java.util.HashSet;

public class LengthOfLongestSubstring {
    public static void main(String[] args){

        String ss = "pwwkew";
        int result = lengthOfLongestSubstring(ss);
        System.out.println(result);

    }

    /**
     * 给定一个字符串，找出不含有重复字符的最长子串的长度。
     * @param s
     * @return
     */
    public static  int lengthOfLongestSubstring(String s) {
        if(s==null||"".equals(s.trim())){
            return 0;
        }
        int length = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i <chars.length ; i++) {
            HashSet<Character> set = new HashSet<>();
            char charstr = chars[i];
            for (int j = i; j <chars.length ; j++) {
                if(!set.contains(chars[j])){
                    set.add(chars[j]);
                    System.out.println(chars[j]);
                }else{
                    System.out.println("equal "+chars[j]);
                    if(set.size()>length){
                        length = set.size();
                    }
                    break;
                }

            }

            set.clear();
        }
        return length;
    }
}
