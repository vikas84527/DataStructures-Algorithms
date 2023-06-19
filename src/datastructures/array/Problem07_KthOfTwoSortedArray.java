package com.learning.dsa._2.array;

import java.util.Arrays;

public class Problem07_KthOfTwoSortedArray {
    public static void main(String[] args) {
        int[] arr1 = {2, 14};
        int[] arr2 = {13, 87, 111, 253, 314};
        System.out.println(kthTwoSortedArray(arr1, arr2, arr1.length, arr2.length, 5));
    }
    public static int kthTwoSortedArray(int[] arr1, int[] arr2, int m, int n, int k_req) {
        int k = 0, i = 0, j = 0;
        while (i < m && j < n) {
            if (arr1[i] < arr2[j]) {
                k++;
                if (k == k_req) return arr1[i];
                i++;
            } else {
                k++;
                if (k == k_req) return arr2[j];
                j++;
            }
        }

        while (i < m) {
            k++;
            if (k == k_req) return arr1[i];
            i++;
        }
        while (j < n) {
            k++;
            if (k == k_req) return arr2[j];
            j++;
        }
        return -1;
    }
}