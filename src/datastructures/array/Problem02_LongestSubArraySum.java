package com.learning.dsa._2.array;

import java.util.HashMap;

import static java.lang.Math.max;

public class Problem02_LongestSubArraySum {
    public static void main(String[] args) {
        int[] arr = {7, 1, 6, 0};
        int n = arr.length, k = 7;

        System.out.println(lenOfLongSubarr(arr, n, k));
    }

    // function to find the length of longest subarray having sum k using prefix Sum
    static int lenOfLongSubarr(int[] arr, int n, int k) {
        // HashMap to store (sum, index) tuples
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0, maxLen = 0;

        // traverse the given array
        for (int i = 0; i < n; i++) {
            sum += arr[i];

            // when subarray starts from index '0'
            if (sum == k) maxLen = i + 1;

            // make an entry for 'sum' if it is not present in 'map'
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }

            // check if 'sum-k' is present in 'map' or not
            if (map.containsKey(sum - k)) {
                // update maxLength
                if (maxLen < (i - map.get(sum - k))) {
                    maxLen = i - map.get(sum - k);
                }
            }
        }
        return maxLen;
    }

}
