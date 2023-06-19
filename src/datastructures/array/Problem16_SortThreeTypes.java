package com.learning.dsa._2.array;

import java.util.Arrays;

public class Problem16_SortThreeTypes {
    public static void main(String[] args) {
        int[] arr = {1, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0};
        int[] arr2 = {1, 0, 2, 2, 0, 0, 0, 1, 1, 2, 0};
        sortTwoTypes(arr);
        sortThreeTypes(arr2);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr2));
    }

    private static void sortThreeTypes(int[] arr) {
        //{1, 0, 2, 2, 0, 0, 0, 1, 1, 2, 0}
        int left = 0, mid = 0, right = arr.length - 1;
        while (mid <= right) {
            switch (arr[mid]) {
                case 0:
                    swap(arr, left, mid);
                    left++;
                    mid++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    swap(arr, mid, right);
                    right--;
            }
        }
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void sortTwoTypes(int[] arr) {

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
