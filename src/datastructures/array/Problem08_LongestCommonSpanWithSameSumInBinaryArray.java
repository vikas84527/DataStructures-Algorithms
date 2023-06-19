package com.learning.dsa._2.array.hashing;

import java.util.HashMap;

public class Problem08_LongestCommonSpanWithSameSumInBinaryArray {
    public static void main(String[] args) {
        int[] arr1 = {0, 1, 0, 0, 0, 0};
        int[] arr2 = {1, 0, 1, 0, 0, 1};
        System.out.println(maxCommonNaive(arr1, arr2));
        System.out.println(maxCommon(arr1, arr2));

    }

    private static int maxCommonNaive(int[] arr1, int[] arr2) {
        int res = 0;
        for (int i = 0; i < arr1.length; i++) {
            int sum1 = 0;
            int sum2 = 0;
            for (int j = i; j < arr2.length; j++) {
                sum1 += arr1[j];
                sum2 += arr2[j];
                if (sum1 == sum2) {
                    res = Math.max(res, j - 1 + 1);
                }
            }
        }
        return res;
    }

    private static int maxCommon(int[] arr1, int[] arr2) {
        int[] temp = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            temp[i] = arr1[i] - arr2[i];
            //or temp[i] = arr2[i] - arr1[i];
        }
        //temp[] = {-1, 1, -1, 0, 0, -1} or {1,-1,1,0,0,1}
        //Now use longest subarray sum 0 to find the max length
        int max_length = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int prefixSum = 0;
        for (int i = 0; i < temp.length; i++) {
            prefixSum += temp[i];
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
