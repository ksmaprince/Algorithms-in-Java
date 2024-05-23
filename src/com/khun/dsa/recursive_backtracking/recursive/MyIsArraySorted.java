package com.khun.dsa.recursive_backtracking.recursive;

public class MyIsArraySorted {
    public boolean isSortedArray(int[] nums, int index) {
        if (index == nums.length - 1) return true;

        return nums[index]<nums[index+1] && isSortedArray(nums, index+1);
    }

    public static void main(String[] args) {
        MyIsArraySorted myIsArraySorted = new MyIsArraySorted();
        int[] nums1 = {1, 2, 3, 4, 5};
        System.out.println(myIsArraySorted.isSortedArray(nums1, 0));
        int[] nums2 = {1, 2, 3, 4, 5, 7, 6, 8, 9, 10};
        System.out.println(myIsArraySorted.isSortedArray(nums2, 0));
    }
}
