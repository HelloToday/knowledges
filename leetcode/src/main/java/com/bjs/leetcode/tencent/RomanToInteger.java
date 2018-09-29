package com.bjs.leetcode.tencent;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

	public static void main(String[] args) {
		System.out.println(intToRoman(88));
		System.out.println(romanToInt("XII"));
	}

	public static String intToRoman(int num) {
		if (num <= 0)
			return "";
		String ret = "";
		int number[] = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
		String flags[] = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };

		for (int i = 0; i < number.length && num > 0; i++) {
			if (num < number[i])
				continue;

			while (num >= number[i]) {
				num -= number[i];
				ret += flags[i];
			}

		}
		return ret;
	}

	public static int romanToInt(String s) {
		Map<Character,Integer> map = new HashMap<Character,Integer>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('C', 100);
		map.put('M', 1000);
		map.put('L', 50);
		map.put('D', 500);
     
        int val = 0;
        for(int i = 0; i < s.length(); i++){
            if(i+1 >= s.length() || map.get(s.charAt(i+1)) <= map.get(s.charAt(i))){
            	val +=map.get(s.charAt(i));
            } else{
            	val -= map.get(s.charAt(i)); 
            }
        }
        return val; 
    }

}
