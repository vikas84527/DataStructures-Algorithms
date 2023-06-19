package com.learning.dsa._2.array.sliding_window;

import java.util.HashMap;
import java.util.LinkedHashSet;

//fixed size (k) sliding window
public class Problem01_MaxSumSubArraySizeK {

    public static void main(String[] args) {
        int[] arr = {4, 2, 1, 7, 8, 1, 2, 1, 8, 0};
        System.out.println(maxSumSubArraySizeK(arr, 3));
        System.out.println(maxSumSubArraySizeK2(arr, 3));
    }

    private static int maxSumSubArraySizeK(int[] arr, int k) {
        int maxSum = Integer.MIN_VALUE;
        int currentRunningSum = 0;
        for (int i = 0; i < arr.length; i++) {
            currentRunningSum += arr[i];
            if (i >= k - 1) {
                maxSum = Math.max(maxSum, currentRunningSum);
                currentRunningSum -= arr[i - (k - 1)];
            }
        }
        return maxSum;
    }

    private static int maxSumSubArraySizeK2(int[] arr, int k) {
        int maxSum = Integer.MIN_VALUE;
        int currentRunningSum = 0;
        int start = 0, end = 0;
        while (end < arr.length) {
            currentRunningSum += arr[end];
            if (end >= k - 1) {
                maxSum = Math.max(maxSum, currentRunningSum);
                currentRunningSum -= arr[start++];
            }
            end++;
        }
        return maxSum;
    }

    //Maximum Sum of Distinct Subarrays With Length K   
    public static long maximumDistinctSubArraySumSizeK(int[] nums, int k) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        long maxSum = 0, sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            mp.put(nums[i], mp.getOrDefault(nums[i], 0) + 1);

            if (i >= k - 1) {
                if (mp.size() == k) {
                    maxSum = Math.max(maxSum, sum);
                }
                sum -= nums[i - k + 1];
                mp.put(nums[i - k + 1], mp.get(nums[i - k + 1]) - 1);
                if (mp.get(nums[i - k + 1]) == 0) mp.remove(nums[i - k + 1]);
            }
        }
        return maxSum;
    }
}
