package com.bjs.leetcode;

import java.util.Stack;
/**
 * 标签解释器
 * @author jinshanbai
 *
 */
public class TagValidator {
	public static void main(String[] args) {
		System.out.println(isValid("<A><A>/A></A></A>"));
	}

	public static boolean isValid(String code) {
		Stack<String> st = new Stack<>();
		for (int i = 0; i < code.length(); i++) {
			if (i > 0 && st.empty())
				return false;
			if (i+9<=code.length()&&code.substring(i, i+9).equals("<![CDATA[")) {
				int j = i + 9-1;
				i = code.substring(j, code.length()).indexOf("]]>");
				if (i < 0)
					return false;
				i = j+i+2;
			} else if (i+2<=code.length()&&code.substring(i, i+2).equals("</")) {
				int j = i + 2;
				i = code.substring(j, code.length()).indexOf(">");
				if (i < 0)
					return false;
				String tag = code.substring(j, i +j);
				if (st.empty() || !st.peek().equals(tag))
					return false;
				st.pop();
				i = i+j;
			} else if (i+1<=code.length()&&code.substring(i, i+1).equals("<")) {
				int j = i + 1;
				i = code.substring(j, code.length() - 1).indexOf(">");
				if (i <= 0 ||i > 9)
					return false;
				for (int k = j; k < i+j; ++k) {
					if (code.charAt(k) < 'A' || code.charAt(k) > 'Z')
						return false;
				}
				String tag = code.substring(j, i + j);
				i = j+i;
				st.push(tag);
			}
		}
		return st.empty();
	}
}
