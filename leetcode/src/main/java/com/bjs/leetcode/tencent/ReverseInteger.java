package com.bjs.leetcode;

public class ReverseInteger {

	public static void main(String[] args) {
		System.out.println(reverse(-251));
	}
	
	public static int reverse(int x) {
		int result = 0;
		while (x != 0) {
			if(result>Integer.MAX_VALUE/10||result<Integer.MIN_VALUE/10){
				return 0;
			}
			result = result * 10 + x % 10; // 每一次都在原来结果的基础上变大10倍，再加上余数
			x = x / 10; // 对x不停除10
		}
		return result;

	}
}
