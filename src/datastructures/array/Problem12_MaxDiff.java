package com.learning.dsa._2.array;

//Maximum difference between two elements such that larger element appears after the smaller number
public class Problem12_MaxDiff {
    public static void main(String[] args) {
        int[] arr = {122, 2, 90, 10, 110};
        System.out.println(maxDiff(arr));
    }

    // Naive: Use two loops. In the outer loop, pick elements one by one and in the inner loop calculate
    // the difference of the picked element with every other element in the array and compare the difference
    // with the maximum difference calculated so far

    //Optimal: keep track of min element and keep subtracting to find the max diff
    private static int maxDiff(int[] arr) {
        int maxDiff = arr[1] - arr[0];
        int minElem = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - minElem > maxDiff) {
                maxDiff = arr[i] - minElem;
            }
            if (arr[i] < minElem) {
                minElem = arr[i];
            }
        }
        return maxDiff;
    }
}
