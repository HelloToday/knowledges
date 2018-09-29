package com.bjs.leetcode.tencent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
	public static void main(String[] args) {

	}

	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> res = new ArrayList();
		// 排序处理
		Arrays.sort(nums);
		for (int k = 0; k < nums.length; k++) {
			int i = k + 1, j = nums.length - 1;
			while (i < j) {
				int value = nums[i] + nums[j];
				if (value == (-nums[k])) {
					List<Integer> list = new ArrayList();
					list.add(nums[k]);
					list.add(nums[i]);
					list.add(nums[j]);
					res.add(list);
					// 重值处理
					// ****一定要有i < j条件，否则i会到最后
					while (i < j && nums[i] == nums[i + 1]) {
						i++;
					}
					// ****一定要有i < j条件，否则j会取-1
					while (i < j && nums[j] == nums[j - 1]) {
						j--;
					}
					// ***
					i++;
					j--;
				} else if (value < (-nums[k]))
					i++;
				else
					j--;
			}
			// ****重值处理
			while (k < nums.length - 1 && nums[k] == nums[k + 1]) {
				k++;
			}
		}
		return res;
	}
}
