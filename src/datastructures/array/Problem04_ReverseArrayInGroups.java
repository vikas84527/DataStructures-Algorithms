package com.learning.dsa._2.array;

import java.util.Arrays;

public class Problem04_ReverseArrayInGroups {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        //reverseArray(arr,0,arr.length-1);
        reverseArrayInGroups(arr, 2);
        System.out.println(Arrays.toString(arr));
    }

    static void reverseArray(int[] arr, int left, int right) {
        while (left <= right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    static void reverseArrayInGroups(int[] arr, int k) {
        for (int i = 0; i < arr.length; i += k) {
            reverseArray(arr, i, Math.min(i + k - 1, arr.length - 1));
        }
    }
}
