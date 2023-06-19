package com.learning.dsa._2.array;

import java.util.Arrays;

public class Problem06_MergeTwoSortedArray {
    public static void main(String[] args) {
        int arr1[] = new int[] { 1, 5, 9, 10, 15, 20 };
        int arr2[] = new int[] { 2, 3, 8, 13 };
        //with extra space
//        mergeTwoSortedArray(arr1, arr2);
//        without extra space
        mergeTwoSortedArray2(arr1, arr2);
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }

    //Naive: use arr3. copy all from arr1 and arr2 into arr3 and then sort.
    //better use TreeMap.
    //better with extra space: see below.
    private static void mergeTwoSortedArray(int[] arr1, int[] arr2) {
        int m = arr1.length;
        int n = arr2.length;
        int i = 0, j = 0, k = 0;
        int[] res = new int[m + n];
        while (i < m && j < n) {
            if (arr1[i] <= arr2[j]) {
                res[k++] = arr1[i++];
            } else {
                res[k++] = arr2[j++];
            }
        }
        while (i < m) {
            res[k++] = arr1[i++];
        }
        while (j < n) {
            res[k++] = arr2[j++];
        }
        System.out.println(Arrays.toString(res));
    }

    //without extra space
    /* The idea is to begin from the last element of ar2[] and search for it in ar1[].
       If there is a greater element in ar1[], then we move the last element of ar1[] to ar2[].
       To keep ar1[] and ar2[] sorted, we need to place the last element of ar2[] at the correct place in ar1[].
       We can use the Insertion Sort for this


   -> Iterate through every element of ar2[] starting from the last element
   -> Do the following for every element ar2[i]
   -> Store last element of ar1[]: last = ar1[m-1]
   -> Loop from the second last element of ar1[] while element ar1[j] is greater than ar2[i].
   -> ar1[j+1] = ar1[j] Move element one position ahead, then j–-
   -> If last element of ar1[] is greater than ar2[i], then ar1[j+1] = ar2[i] and ar2[i] = last
   */
    private static void mergeTwoSortedArray2(int[] arr1, int[] arr2) {
        int m = arr1.length;
        int n = arr2.length;
        // Iterate through all elements of ar2[] starting from the last element
        for (int i = n - 1; i >= 0; i--) {
            /* Find the smallest element greater than ar2[i]. Move all elements one position ahead
               till the smallest greater element is not found */
            int j, last = arr1[m - 1];
            for (j = m - 2; j >= 0 && arr1[j] > arr2[i]; j--)
                arr1[j + 1] = arr1[j];

            // If there was a greater element
            if (last > arr2[i]) {
                arr1[j + 1] = arr2[i];
                arr2[i] = last;
            }
        }
    }
}
