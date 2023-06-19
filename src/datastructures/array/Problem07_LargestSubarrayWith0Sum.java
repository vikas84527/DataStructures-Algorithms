package com.learning.dsa._2.array.hashing;

import java.util.HashMap;

public class Problem07_LargestSubarrayWith0Sum {
    public static void main(String[] args) {
        int[] arr = {15, -2, 2, -8, 1, 7, 10, 23};
        System.out.println(maxLen(arr));

    }

    private static int maxLen(int[] arr) {
        int max_len = 0;
        for (int i = 0; i < arr.length; i++) {
            int curr_sum = 0;
            for (int j = i; j < arr.length; j++) {
                curr_sum += arr[j];
                if (curr_sum == 0)
                    max_len = Math.max(max_len, j - i + 1);
            }
        }
        return max_len;
    }

    static int maxLenSubSumZero(int[] ar, int size) {
        int max_length = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int prefixSum = 0;
        for (int i = 0; i < ar.length; i++) {
            prefixSum += ar[i];
            if (ar[i] == 0 && max_length == 0)
                max_length = 1;
            if (prefixSum == 0)
                max_length = i + 1;
            if (map.containsKey(prefixSum)) {
                max_length = Math.max(max_length, i - map.get(prefixSum));
            } else {
                map.put(prefixSum, i);
            }
        }
        return max_length;
    }
}
