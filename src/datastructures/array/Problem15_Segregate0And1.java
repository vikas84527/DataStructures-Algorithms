package com.learning.dsa._2.array;

import java.util.Arrays;

//same applies for segregate odd even
public class Problem15_Segregate0And1 {
    public static void main(String[] args) {
        int[] arr = {1, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0};
        segregateZeroOne(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void segregateZeroOne(int[] arr) {
        int left = -1, right = arr.length;
        while (true) {
            do {
                left++;
            } while (arr[left] == 0);
            do {
                right--;
            } while (arr[right] == 1);

            if (left >= right) {
                return;
            }
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
        }
    }
}
