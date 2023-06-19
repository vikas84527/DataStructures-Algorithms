package com.learning.dsa._2.array.hashing;

import java.util.HashSet;
import java.util.Set;

//for sorted array use two pointer approach
public class Problem02_PairWithGivenSUmUnsortedArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        pairSum(arr, 9);
    }

    private static void pairSum(int[] arr, int targetSum) {
        Set<Integer> set = new HashSet<>();
        for (int num : arr) {
            if (set.contains(targetSum - num)) {
                System.out.println(num + "," + (targetSum - num));
            } else {
                set.add(num);
            }
        }
    }
}
