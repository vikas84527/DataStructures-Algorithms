package com.learning.dsa._2.array.sliding_window;

public class Problem05_LargestSumContiguousSubarrayKadaneAlgorithm {
    public static void main(String[] args) {
        int[] a = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println("Maximum contiguous sum is " + maxSubArraySum(a));
    }

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
