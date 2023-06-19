package com.learning.dsa._2.array.sliding_window;

//Given an integer array nums, find the subarray
// with the largest sum, and return its sum.

public class Problem06_MaxSubArraySum {
    // Function Call
    static int maxSubArraySum(int[] arr) {
        int size = arr.length;
        int maxSum = Integer.MIN_VALUE, currSum = 0;

        for (int i = 0; i < size; i++) {
            currSum += arr[i];
            maxSum = Math.max(currSum, maxSum);
            if (currSum < 0) {
                currSum = 0;
            }
        }
        return maxSum;
    }
}
