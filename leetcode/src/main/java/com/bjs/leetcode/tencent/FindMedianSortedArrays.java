package com.bjs.leetcode.tencent;

public class FindMedianSortedArrays {

    public static void main(String[] args) {
        int[] numbs1 ={3};
        int[] numbs2 ={-2,-1};
        System.out.println(findMedianSortedArrays(numbs1,numbs2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double sum = 0;
        double count = nums1.length+nums2.length;
        for (int i =0 ;i<nums1.length;i++){
            sum+=Math.abs(nums1[i]);
        }
        for (int i =0 ;i<nums2.length;i++){
            sum+=Math.abs(nums2[i]);
        }
        double result = sum/count;
        return result;
    }
}
