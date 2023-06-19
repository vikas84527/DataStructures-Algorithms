package com.learning.dsa._2.array.hashing;

import java.util.HashSet;
import java.util.Set;

public class Problem03_SubarrayWith0Sum {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, -7, 1, 45, 6, 6, 7};
        System.out.println(subArraySum0(arr));
    }

    private static boolean subArraySum0(int[] arr) {
        int prefixSum = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];
            //condition for when starting index of required subarray is 0
            if (prefixSum == 0) return true;
            if (set.contains(prefixSum)) {
                return true;
            } else {
                set.add(prefixSum);
            }
        }
        return false;
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
