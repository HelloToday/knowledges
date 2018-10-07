package com.bjs.leetcode.tencent;

import java.util.Arrays;

public class ThreeSumClosest {
    public static void main(String[] args) {
        int nums[] = {-73,-26,10,-40,-74,81,20,-52,80,32,-17,-20,19,34,-2,94,-81,-66,-17,93,26,36,54,40,40,32,3,77,-30,14,-28,-74,-60,-99,11,0,-31,-84,90,-51,-29,87,-67,55,6,96,9,-76,75,-44,32,89,13,46,29,66,-12,-90,81,43,-46,54,74,22,70,-66,-43,97,93,-26,6,45,9,-64,-11,-43,-78,44,-92,98,-65,29,83,-30,35,-63,13,-92,-9,79,95,-44,50,55,87,-69,81,-91,-57,5,-9,65,42,11,78,-4,-43,10,1,0,50,-37,100,61,-82,-13,100,46,0,-25,13,16,43,49,92,31,85,38,-63,6,-30,67,64,-4,-71,-74,-92,6,-50,-45,-71,-82,11,-39};
        int target = 299;

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
                int tem_diff = Math.abs(temp_sum-target);

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
