package com.learning.dsa._2.array;

public class Problem03_SearchInRowColumnSortedMatrix {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 4},
                {16, 23, 24},
                {51, 55, 66}
        };
        //as matrix is sorted we can use binary search
        searchIn2DArray(arr, 66);
    }

    private static void searchIn2DArrayNaive(int[][] arr, int k) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == k) {
                    System.out.println("i: " + i + " j: " + j);
                    return;
                }
            }
        }
        System.out.println("element not found");
    }

    //using binary search
    private static void searchIn2DArray(int[][] arr, int k) {

        int i = 0;
        int j = arr[0].length - 1;
        while (i < arr.length && j>=0) {
            if (arr[i][j] == k) {
                System.out.println(i + " " + j);
                return;
            } else if (arr[i][j] < k) {
                i++;
            } else {
                j--;
            }
        }
        System.out.println(-1);

    }
}
