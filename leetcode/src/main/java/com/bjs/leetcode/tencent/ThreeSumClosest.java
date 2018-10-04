package com.bjs.leetcode.tencent;

import java.util.Arrays;

public class ThreeSumClosest {
    public static void main(String[] args) {
        int nums[] = {-1,2,1,-4,0};
        int target = 1;

        int result = solution(nums,target);
        System.out.println(result);
    }

    static  int solution(int nums[],int target){
        Arrays.sort(nums);
        int closestSum = 0;
        int diff = Integer.MAX_VALUE;

        for (int i = 0; i <nums.length-2 ; i++) {
            int left = i+1;
            int right = nums.length -1;
            while (left<right){
                int temp_sum = nums[i]+nums[left]+nums[right];
                System.out.println(nums[i]+"#"+nums[left]+nums[right]);
                int tem_diff = Math.abs(temp_sum-target);
                System.out.println("diff is "+ tem_diff);
                if(tem_diff<diff){
                    diff = tem_diff;
                    closestSum = temp_sum;
                }
                if(temp_sum<target){
                    left++;
                }else if (temp_sum>target){
                    right --;
                }else{
                    return temp_sum;
                }

            }

        }
        return closestSum;
    }

}
