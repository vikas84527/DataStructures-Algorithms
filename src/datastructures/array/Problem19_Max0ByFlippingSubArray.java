package com.learning.dsa._2.array;

public class Problem19_Max0ByFlippingSubArray {
    //Max Consecutive 1 if we can flip k Zeros
    public static int maxConsOne(int[] arr, int k) {
        int maxOne = 0;
        int zeroCount = 0;
        int start = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                zeroCount++;
            }
            while (zeroCount > k) {
                if (arr[i] == 0) {
                    zeroCount--;
                }
                start++;
            }
            maxOne = Math.max(maxOne, i - start + 1);
        }
        return maxOne;
    }


    // A Kadane's algorithm based solution to find maximum number of 0s by flipping a subarray.
    public static int findMaxZeroCount(int arr[], int n) {
        int max_diff = 0;
        int orig_zero_count = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0)
                orig_zero_count++;
            int count1 = 0, count0 = 0;
            // Consider all subarrays starting from arr[i] and find the difference between 1s and 0s.
            // Update max_diff if required
            for (int j = i; j < n; j++) {
                if (arr[j] == 1) {
                    count1++;
                } else {
                    count0++;
                }
                max_diff = Math.max(max_diff, count1 - count0);
            }
        }
        return orig_zero_count + max_diff;
    }

    /*
   This problem can be reduced to largest subarray sum problem.
   The idea is to consider every 0 as -1 and every 1 as 1, find the sum of largest subarray sum in this
   modified array. This sum is our required max_diff ( count of 0s – count of 1s in any subarray).
   Finally we return the max_diff plus count of zeros in original array.
    */
    public static int findMaxZeroCountOptimal(int[] arr, int n) {
        int orig_zero_count = 0;
        int max_diff = 0;
        int curr_max = 0;
        for (int i = 0; i < n; i++) {
            // Count of zeros in original array (Not related to Kadane's algorithm)
            if (arr[i] == 0) {
                orig_zero_count++;
            }
            // Value to be considered for finding maximum sum
            int val = (arr[i] == 1) ? 1 : -1;
            // Update current max and max_diff
            curr_max = Math.max(val, curr_max + val);
            max_diff = Math.max(max_diff, curr_max);
        }
        max_diff = Math.max(0, max_diff);
        return orig_zero_count + max_diff;
    }

    public static void main(String[] args) {
        int[] arr = {0, 0, 1, 0, 1, 1, 0};

        System.out.println(findMaxZeroCountOptimal(arr, arr.length));
        System.out.println(maxConsOne(arr, 2));
    }
}