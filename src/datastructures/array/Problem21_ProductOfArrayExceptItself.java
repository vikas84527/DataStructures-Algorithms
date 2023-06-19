package com.learning.dsa._2.array;

import java.util.Arrays;

public class Problem21_ProductOfArrayExceptItself {
    
    static void productArray(int[] arr) {
        int[] out = new int[arr.length];
        Arrays.fill(out, 1);
        
        for (int i = 1; i < arr.length; i++) {
            out[i] = out[i - 1] * arr[i - 1];
        }
        int R = 1;
        for (int i = arr.length - 1; i >= 0; i--) {
            out[i] = out[i] * R;
            R = R * arr[i];
        }
        System.out.println(Arrays.toString(out));
    }

    static void productArrayNaive(int[] arr, int n) {
        if (n == 1) {
            System.out.print(0);
            return;
        }
        int[] left = new int[n];
        int[] right = new int[n];
        int[] prod = new int[n];
        int i, j;
        /* Left most element of left array is always 1 */
        left[0] = 1;
        /* Right most element of right array is always 1 */
        right[n - 1] = 1;
        /* Construct the left array */
        for (i = 1; i < n; i++) {
            left[i] = arr[i - 1] * left[i - 1];
        }
        /* Construct the right array */
        for (j = n - 2; j >= 0; j--) {
            right[j] = arr[j + 1] * right[j + 1];
        }
        /* Construct the product array using left[] and right[] */
        for (i = 0; i < n; i++) {
            prod[i] = left[i] * right[i];
        }
        System.out.println(Arrays.toString(prod));
    }

    static void productArrayBetter(int[] arr, int n) {
        if (n == 1) {
            System.out.print("0");
            return;
        }
        int i, temp = 1;
        /* Allocate memory for the product array */
        int[] prod = new int[n];
        /* Initialize the product array as 1 */
        for (int j = 0; j < n; j++)
            prod[j] = 1;
        /* In this loop, temp variable contains product of elements on left side excluding arr[i] */
        for (i = 0; i < n; i++) {
            prod[i] = temp;
            temp *= arr[i];
        }
        /* Initialize temp to 1 for product on right side */
        temp = 1;
        /* In this loop, temp variable contains product of
           elements on right side excluding arr[i] */
        for (i = n - 1; i >= 0; i--) {
            prod[i] *= temp;
            temp *= arr[i];
        }
        System.out.println(Arrays.toString(prod));
    }

    /* Driver program to test the above function */
    public static void main(String[] args) {
//        int[] arr = {10, 3, 5, 6, 2};
        int[] arr = {1, 2, 3, 4};
        int n = arr.length;
        productArrayNaive(arr, n);
        productArray(arr);
        productArrayBetter(arr, n);
    }


}
