package com.learning.dsa._2.array;

import java.util.Vector;

public class Problem20_0sToBeFlippedForMaxConsecutive1 {
    public static void main(String[] args) {

    }

    /*
     For all positions of 0’s calculate left[] and right[] which defines the number of consecutive
     1’s to the left of i and right of i respectively.
    For example, for arr[] = {1, 1, 0, 1, 1, 0, 0, 1, 1, 1} and m = 1, left[2] = 2 and right[2] = 2,
     left[5] = 2 and right[5] = 0, left[6] = 0 and right[6] = 3.

    left[] and right[] can be filled in O(n) time by traversing array once and keeping track of
    last seen 1 and last seen 0. While filling left[] and right[], we also store indexes of all zeroes
    in a third array say zeroes[]. For above example, this third array stores {2, 5, 6}
    */

    // m is maximum of number zeroes allowed to flip
// n is size of array
    static Vector<Integer> maximized_one(int[] arr, int n, int m)
    {
        // Left array
        int[] left = new int[n];
        // Right array
        int[] right = new int[n];
        // Array will contain zeroes position
        Vector<Integer> zero_pos = new Vector<>();
        // Stores count
        int count = 0;
        int previous_index_of_zero = -1;
        for (int i = 0; i < n; i++) {
            if (arr[i]!=0) {
                count++;
            }
            else {
                left[i] = count;
                zero_pos.add(i);
                if (previous_index_of_zero != i
                        && previous_index_of_zero != -1) {
                    right[previous_index_of_zero] = count;
                }
                count = 0;
                // To keep track of the previous index of zeroes
                previous_index_of_zero = i;
            }
        }
        right[previous_index_of_zero] = count;

        int max_one = -1;
        Vector<Integer> result_index = new Vector<>();
        int i = 0;

        while (i <= (zero_pos.size()) - m) {
            int temp = 0;
            Vector<Integer> index = new Vector<>();

            for (int c = 0; c < m; c++) {
                temp += left[zero_pos.elementAt(i + c)]
                        + right[zero_pos.elementAt(i + c)] + 1;
                // Index is updated
                index.add(zero_pos.elementAt(i + c));
            }
            // Decrement temp by m-1 because when we are
            // calculating temp we are adding 1 in it. So, in
            // order to get exact count of 1. This decrement is
            // applicable only when value of m is greater than 1
            temp = temp - (m - 1);
            // Updating max value when we get the new max temp
            // and result_index as well
            if (temp > max_one) {
                max_one = temp;
                result_index = index;
            }
            i += 1;
        }

        return result_index;
    }
}
