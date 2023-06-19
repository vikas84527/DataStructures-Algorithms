package com.learning.dsa._2.array;

import java.util.Arrays;

public class Problem23_SetMatrixZeros {

    public static void main(String[] args) {
//        int[][] matrix = {{1, 1, 1}, 
//                          {1, 0, 1}, 
//                          {1, 1, 1}};
        int[][] matrix = {{0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}};
        // call method
        setZeroesBest(matrix);
        for (int[] arr : matrix) {
            System.out.println(Arrays.toString(arr));
        }
    }


    /*Naive:
    Assuming all the elements in the matrix are non-negative. Traverse through the matrix and if you find an
    element with value 0, then change all the elements in its row and column to -1,
    except when an element is 0. The reason for not changing other elements to 0, but -1,
    is because that might affect other columns and rows.
    Now traverse through the matrix again and if an element is -1 change it to 0, which will be the answer.
    */
    static void setZeroesNaive(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    int ind = i - 1;
                    while (ind >= 0) {
                        if (matrix[ind][j] != 0) {
                            matrix[ind][j] = -1;
                        }
                        ind--;
                    }
                    ind = i + 1;
                    while (ind < rows) {
                        if (matrix[ind][j] != 0) {
                            matrix[ind][j] = -1;
                        }
                        ind++;
                    }
                    ind = j - 1;
                    while (ind >= 0) {
                        if (matrix[i][ind] != 0) {
                            matrix[i][ind] = -1;

                        }
                        ind--;
                    }
                    ind = j + 1;
                    while (ind < cols) {
                        if (matrix[i][ind] != 0) {
                            matrix[i][ind] = -1;

                        }
                        ind++;
                    }
                }
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] <= 0) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    //Optimal
    //Approach:Take two dummy array one of size of row and other of size of column.
    // Now traverse through the array.If matrix[i][j]==0 then set dummy1[i]=0(for row) and
    // dummy2[j]=0(for column).Now traverse through the array again and if
    // dummy1[i]==0  || dummy2[j]==0 then arr[i][j]=0, else continue.

    static void setZeroesOptima(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        int[] dummy1 = new int[rows];
        int[] dummy2 = new int[cols];
        Arrays.fill(dummy1, -1);
        Arrays.fill(dummy2, -1);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    dummy1[i] = 0;
                    dummy2[j] = 0;
                }
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dummy1[i] == 0 || dummy2[j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    static void setZeroesBest(int[][] matrix) {
        int col0 = 1, rows = matrix.length, cols = matrix[0].length;
        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == 0) {
                col0 = 0;
            }
            for (int j = 1; j < cols; j++)
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0; 
                    matrix[0][j] = 0;
                }
        }


        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 1; j--)
                if (matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            if (col0 == 0) {
                matrix[i][0] = 0;
            }
        }
    }
}
