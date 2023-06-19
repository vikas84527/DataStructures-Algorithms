package com.learning.dsa._2.array;

import java.util.Arrays;

public class Problem22_AlternatePositiveNegative {

    public static void main(String[] args) {
        int[] arr = {9, -3, 5, -2, -8, -6, 1, 3};
        rearrange(arr);
        System.out.println(Arrays.toString(arr));
    }

    //Using O(n) extra space
    public static int[] rearrangeArray(int[] nums) {
        int[] out = new int[nums.length];
        int j = 0;
        int k = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                out[j] = nums[i];
                j += 2;
            } else {
                out[k] = nums[i];
                k += 2;
            }
        }
        return out;
    }

    // Function to rearrange a given array such that it contains positive
    // and negative numbers at alternate positions -> O(n) O(1)
    public static void rearrange(int[] A) {
        // partition a given array such that all positive elements move to the end of the array
        int p = partition(A);
        // swap alternate negative elements from the next available positive element
        // till the end of the array is reached, or all negative or positive elements are exhausted.
        for (int i = 0; (p < A.length && i < p); p++, i += 2) {
            // swap `A[i]` with `A[p]`
            int temp = A[i];
            A[i] = A[p];
            A[p] = temp;
        }
    }

    // Partitioning routine of Quicksort
    public static int partition(int[] A) {
        int j = 0;
        int pivot = 0;    // consider 0 as a pivot
        // each time we find a negative number, `j` is incremented,
        // and a negative element would be placed before the pivot
        for (int i = 0; i < A.length; i++) {
            if (A[i] < pivot) {
                // swap `A[i]` with `A[j]`
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;

                j++;
            }
        }
        // `j` holds the index of the first positive element
        return j;
    }
}
