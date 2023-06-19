package com.learning.dsa._2.array.sliding_window;

import java.util.HashMap;

//dynamic size sliding window
public class Problem02_SmallestLargestSubArrayWithGivenSum {
    public static void main(String[] args) {
        int[] arr = {4, 2, 2, 7, 6, 1, 2, 7, 0, 0, 0, 1, 0};
        System.out.println(smallestSubArraySum(arr, 8));
        System.out.println(lenOfLongSubarr(arr, arr.length, 8));
        System.out.println(findMaxSubarrayLength(arr, 8));

    }

    private static int smallestSubArraySum(int[] arr, int targetSum) {
        int minWindowSize = Integer.MAX_VALUE;
        int currWindowSum = 0;
        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            currWindowSum += arr[windowEnd];
            while (currWindowSum >= targetSum) {
                minWindowSize = Math.min(minWindowSize, windowEnd - windowStart + 1);
                currWindowSum -= arr[windowStart++];
            }
        }
        return minWindowSize;
    }

    static int lenOfLongSubarr(int[] arr, int n, int targetSum) {
        // HashMap to store (sum, index) tuples
        HashMap<Integer, Integer> map = new HashMap<>();
        int prefixSum = 0, maxLen = 0;

        // traverse the given array
        for (int i = 0; i < n; i++) {
            prefixSum += arr[i];
            // when subarray starts from index '0'
            if (prefixSum == targetSum) {
                maxLen = i + 1;
            }
            // make an entry for 'sum' if it is not present in 'map'
            if (!map.containsKey(prefixSum)) {
                map.put(prefixSum, i);
            }
            // check if 'sum-k' is present in 'map' or not
            if (map.containsKey(prefixSum - targetSum)) {
                // update maxLength
                if (maxLen < (i - map.get(prefixSum - targetSum))) {
                    maxLen = i - map.get(prefixSum - targetSum);
                }
            }
        }
        return maxLen;
    }

    public static int findMaxSubarrayLength(int[] arr, int sum) {
        int left = 0;
        int right = 0;
        int currentSum = arr[0];
        int maxLength = 0;

        while (right < arr.length) {
            if (currentSum >= sum) {
                int length = right - left + 1;
                maxLength = Math.max(maxLength, length);
                currentSum -= arr[left];
                left++;
            } else {
                right++;
                if (right < arr.length) {
                    currentSum += arr[right];
                }
            }
        }

        return maxLength;
    }

}
