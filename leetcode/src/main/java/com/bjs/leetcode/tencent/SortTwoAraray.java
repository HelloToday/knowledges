package com.bjs.leetcode.tencent;

public class SortTwoAraray {
    public static void main(String[] args) {
        int[] nums1 = {1,3,5};
        int[] nums2 = {2,4,6};

        merger(nums1,nums1.length,nums2,nums2.length);
    }

    public static void merger(int[] nums1,int m,int[] nums2, int n) {
        int[] result = new int[m+n];

        int i =0,j=0,k=0;
        while (i<nums1.length&&j<nums2.length){
            if(nums1[i]<=nums2[j]){
                result[k] = nums1[i];
                k++;
                i++;
            }else{
                result[k] = nums2[j];
                k++;
                j++;
            }
        }
        while (i<nums1.length){
            result[k] = nums1[i];
            k++;
            i++;
        }

        while (j<nums2.length){
            result[k] = nums2[j];
            k++;
            j++;
        }

        for (int l = 0; l < result.length; l++) {
            System.out.println(result[l]);
        }
    }
}
