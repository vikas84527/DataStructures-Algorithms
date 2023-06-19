package com.learning.dsa._2.array.hashing;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//we need to find the longest subsequence in the form of
//x x+1 x+2 x+i with the elements appearing in any order
public class Problem09_LongestConsecutiveSubsequence {
    public static void main(String[] args) {
        int[] arr = {2, 9, 4, 3, 10};
        System.out.println(longestConsecutiveSubsequence(arr));
        System.out.println(longestConsecutiveSubsequence2(arr));

    }

    //wrong
    private static int longestConsecutiveSubsequence(int[] arr) {
        int res = 1, curr = 1;
        Arrays.sort(arr);
        //2,3,4,9,10
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1] + 1) {
                curr++;
            } else if (arr[i] != arr[i - 1]) {
                res = Math.max(res, curr);
                curr = 1;
            }
        }
        return Math.max(res, curr);
    }

    private static int longestConsecutiveSubsequence2(int[] arr) {

        Set<Integer> hset = new HashSet<>();
        for (int elem : arr) {
            hset.add(elem);
        }
        int res = 1;
        for (int elem : arr) {
            if (!hset.contains(elem - 1)) {
                int curr = 1;
                while (hset.contains(elem + curr)) {
                    curr++;
                    res = Math.max(res, curr);
                }
            }
        }
        return res;
    }
}
