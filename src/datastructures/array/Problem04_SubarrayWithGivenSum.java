package com.learning.dsa._2.array.hashing;

import java.util.HashSet;
import java.util.Set;

public class Problem04_SubarrayWithGivenSum {
    public static void main(String[] args) {
        int[] arr = {1, 1, 1, -7, 6, 6, 7}; // 1,2,3,-4,2,8,15
        System.out.println(subArrayWithGivenSum(arr, 0));
    }

    private static boolean subArrayWithGivenSum(int[] arr, int targetSum) {
        int prefixSum = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];
            if (prefixSum == targetSum) return true;
            if (set.contains(prefixSum - targetSum)) {
                return true;
            } else {
                set.add(prefixSum);
            }
        }
        return false;
    }
}
