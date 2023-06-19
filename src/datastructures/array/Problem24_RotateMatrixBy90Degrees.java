package com.learning.dsa._2.array;

public class Problem24_RotateMatrixBy90Degrees {

    // An Inplace function to rotate a N x N matrix by 90 degrees in anti-clockwise direction
    static void rotateMatrix(int N, int[][] mat) {
        // Consider all squares one by one
        for (int i = 0; i < N / 2; i++) {
            // Consider elements in group of 4 in current square
            for (int j = i; j < N - i - 1; j++) {
                // Store current cell in temp variable
                int temp = mat[i][j];
                // Move values from right to top
                mat[i][j] = mat[j][N - 1 - i];
                // Move values from bottom to right
                mat[j][N - 1 - i] = mat[N - 1 - i][N - 1 - j];
                // Move values from left to bottom
                mat[N - 1 - i][N - 1 - j] = mat[N - 1 - j][i];
                // Assign temp to left
                mat[N - 1 - j][i] = temp;
            }
        }
    }

    // Function to print the matrix
    static void displayMatrix(int N, int mat[][]) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(" " + mat[i][j]);
            System.out.println();
        }
        System.out.println();
    }
//=================================================================================
    //2: Rotate matrix Using Transpose Method
    // An Inplace function to rotate a N x N matrix by 90 degrees in anti-clockwise direction
    static void rotateMatrixTranspose(int N, int[][] mat) {
        // REVERSE every row
        for (int i = 0; i < N; i++)
            Reverse(i, mat, N);

        // Performing Transpose
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }
    }
    // Function to reverse the given 2D arr[][]
    static void Reverse(int i, int[][] mat, int N) {
        int start = 0;
        int end = N - 1;
        // Till start < end, swap the element at start and end index
        while (start < end) {
            // Swap the element
            int temp = mat[i][start];
            mat[i][start] = mat[i][end];
            mat[i][end] = temp;

            // Increment start and decrement end for next pair of swapping
            start++;
            end--;
        }
    }

    //=================================================================================
    //In clockwise direction:
    //Rotate a matrix by 90 degree in clockwise direction without using any extra space
    static int N = 4;

    static void rotate90Clockwise(int[][] a) {
        // Traverse each cycle
        for (int i = 0; i < N / 2; i++) {
            for (int j = i; j < N - i - 1; j++) {
                // Swap elements of each cycle in clockwise direction
                int temp = a[i][j];
                a[i][j] = a[N - 1 - j][i];
                a[N - 1 - j][i] = a[N - 1 - i][N - 1 - j];
                a[N - 1 - i][N - 1 - j] = a[j][N - 1 - i];
                a[j][N - 1 - i] = temp;
            }
        }
    }


    public static void main(String[] args) {
        int N = 3;

        int[][] mat = {{1, 2, 3},
                {4,5,6},{7,8,9}};

        rotateMatrixTranspose(N, mat);
        displayMatrix(N, mat);
    }
}
