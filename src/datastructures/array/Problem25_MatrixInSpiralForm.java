package com.learning.dsa._2.array;

public class Problem25_MatrixInSpiralForm {
    private static void printSpiralOrder(int[][] mat) {
        if (mat == null || mat.length == 0) {
            return;
        }
        int top = 0, bottom = mat.length - 1;
        int left = 0, right = mat[0].length - 1;
        while (true) {
            if (left > right) {
                break;
            }
            // print top row
            for (int i = left; i <= right; i++) {
                System.out.print(mat[top][i] + " ");
            }
            top++;
            if (top > bottom) {
                break;
            }
            // print right column
            for (int i = top; i <= bottom; i++) {
                System.out.print(mat[i][right] + " ");
            }
            right--;
            if (left > right) {
                break;
            }
            // print bottom row
            for (int i = right; i >= left; i--) {
                System.out.print(mat[bottom][i] + " ");
            }
            bottom--;
            if (top > bottom) {
                break;
            }
            // print left column
            for (int i = bottom; i >= top; i--) {
                System.out.print(mat[i][left] + " ");
            }
            left++;
        }
    }

    private static void printSpiralRecursive(int mat[][], int top, int bottom, int left, int right) {
        // base case
        if (mat == null || mat.length == 0 || left > right) {
            return;
        }

        // print top row
        for (int i = left; i <= right; i++) {
            System.out.print(mat[top][i] + " ");
        }
        top++;

        if (top > bottom) {
            return;
        }
        // print right column
        for (int i = top; i <= bottom; i++) {
            System.out.print(mat[i][right] + " ");
        }
        right--;

        if (left > right) {
            return;
        }
        // print bottom row
        for (int i = right; i >= left; i--) {
            System.out.print(mat[bottom][i] + " ");
        }
        bottom--;

        if (top > bottom) {
            return;
        }
        // print left column
        for (int i = bottom; i >= top; i--) {
            System.out.print(mat[i][left] + " ");
        }
        left++;

        printSpiralRecursive(mat, top, bottom, left, right);
    }

    public static void main(String[] args) {
        int[][] mat = {{1, 2, 3, 4, 5},
                      {16, 17, 18, 19, 6},
                      {15, 24, 25, 20, 7},
                      {14, 23, 22, 21, 8},
                     {13, 12, 11, 10, 9}};

        printSpiralOrder(mat);
        int top = 0, bottom = mat.length - 1;
        int left = 0, right = mat[0].length - 1;
        System.out.println();
        printSpiralRecursive(mat, top, bottom, left, right);
    }
}
