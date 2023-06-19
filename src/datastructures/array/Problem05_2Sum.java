package com.learning.dsa._2.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//Naive
//TwoPointer
//HashMap
public class Problem05_2Sum {
    public static void main(String[] args) {
        int[] arr = {23, 54, 76, 23, 78, 11, 2, 46, 77, 3};
        twoSumNaive(arr, 56);
        twoSumBetter(arr, 56);
        twoSumOptimal(arr, 56);
    }

    //can print both elements and index
    private static void twoSumNaive(int[] arr, int target) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == target) {
                    System.out.println(i + ":" + j);
                }
            }
        }
    }

    //index can not be printed as we are sorting
    private static void twoSumBetter(int[] arr, int target) {
        Arrays.sort(arr);
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == target) {
                System.out.println(arr[left] + ":" + arr[right]);
                return;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        System.out.println("Not found");
    }

    //can print both elements and index
    private static void twoSumOptimal(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(target - arr[i])) {
                System.out.println(i + ":" + map.get(target - arr[i]));
                return;
            } else {
                map.put(arr[i], i);
            }
        }
        System.out.println("Not found");
    }
}
