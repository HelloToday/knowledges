package com.bjs.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LengthOfSubString {
	public static void main(String[] args) {
		
		
		System.out.println(lengthOfLongestSubstring2("ddeddfdssfssfss"));
	}
	
    public static int lengthOfLongestSubstring(String s) {
    	int n = s.length();
    	int ans = 0;
    	for(int i=0;i<n;i++){
    		for(int j=i+1;j<=n;j++){
    			if(allUnique(s,i,j)){
    				ans = Math.max(ans, j-i);
    			}
    		}
    	}
        return ans;
    }
    /**
     * 窗口滑动的方式来处理这个字符串
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring2(String s) {
    	int n = s.length();
    	int ans = 0,i=0,j=0;
    	Set<Character> set = new HashSet<>();
    	
    	while(i<n&&j<n){
    		if(!set.contains(s.charAt(j))){
    			set.add(s.charAt(j++));
    			ans = Math.max(ans, j-i);
    		}else{
    			set.remove(s.charAt(i++));
    		}
    	}
    	return ans;
    }

	private static boolean allUnique(String s, int start, int end) {
		Set<Character> set = new HashSet<>();
		for(int i = start;i<end;i++){
			if(set.contains(s.charAt(i))){
				return false;
			}
			set.add(s.charAt(i));
		}
		return true;
	}
}
