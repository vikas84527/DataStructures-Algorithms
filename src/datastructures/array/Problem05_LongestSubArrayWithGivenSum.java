package com.learning.dsa._2.array.hashing;

import java.util.HashMap;
import java.util.Map;

public class Problem05_LongestSubArrayWithGivenSum {
    public static void main(String[] args) {
        int[] arr = {8, 3, 1, 5, -6, 6, 2, 2};
        longestSubArrayWithGivenSum(arr, 3);
    }

    private static void longestSubArrayWithGivenSum(int[] arr, int targetSum) {
        int prefixSum = 0;
        int maxLen = 0;
        //start,end;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];
            if (prefixSum == targetSum) {
                maxLen = i + 1;
                //start=0,end=i+1;
            }
            if (!map.containsKey(prefixSum)) {
                map.put(prefixSum, i);
            }
            if (map.containsKey(prefixSum - targetSum)) {
                maxLen = Math.max(maxLen, i - map.get(prefixSum - targetSum));
                //start map.get(prefixSum - targetSum) end = i - map.get(prefixSum - targetSum)
            }
        }
        System.out.println(maxLen);
    }
}
