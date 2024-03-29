package com.learning.dsa._2.array;

import java.util.Arrays;

public class Problem26_MedianTwoSortedArray {

    /*
    1) Calculate the medians m1 and m2 of the input arrays ar1[]
   and ar2[] respectively.
2) If m1 and m2 both are equal then we are done.
     return m1 (or m2)
3) If m1 is greater than m2, then median is present in one
   of the below two subarrays.
    a)  From first element of ar1 to m1 (ar1[0...|_n/2_|])
    b)  From m2 to last element of ar2  (ar2[|_n/2_|...n-1])
4) If m2 is greater than m1, then median is present in one
   of the below two subarrays.
   a)  From m1 to last element of ar1  (ar1[|_n/2_|...n-1])
   b)  From first element of ar2 to m2 (ar2[0...|_n/2_|])
5) Repeat the above process until size of both the subarrays
   becomes 2.
6) If size of the two arrays is 2 then use below formula to get
  the median.
    Median = (max(ar1[0], ar2[0]) + min(ar1[1], ar2[1]))/2
     */

    /* This function returns median of ar1[] and ar2[].
    Assumptions in this function:
        Both ar1[] and ar2[] are  sorted arrays Both have n elements */
    static int getMedian(int[] a, int[] b, int startA, int startB, int endA, int endB) {
        if (endA - startA == 1) {
            return (Math.max(a[startA], b[startB]) + Math.min(a[endA], b[endB])) / 2;
        }
        /* get the median of the first array */
        int m1 = median(a, startA, endA);

        /* get the median of the second array */
        int m2 = median(b, startB, endB);

        /* If medians are equal then return either m1 or m2 */
        if (m1 == m2) {
            return m1;
        }
        /* if m1 < m2 then median must exist in ar1[m1....] and ar2[....m2] */
        else if (m1 < m2) {
            return getMedian(a, b, (endA + startA + 1) / 2, startB, endA, (endB + startB + 1) / 2);
        }
        /* if m1 > m2 then median must exist in ar1[....m1] and ar2[m2...] */
        else {
            return getMedian(a, b, startA, (endB + startB + 1) / 2, (endA + startA + 1) / 2, endB);
        }
    }

    /* Function to get median
    of a sorted array */
    static int median(int[] arr, int start, int end) {
        int n = end - start + 1;
        if (n % 2 == 0) {
            return (arr[start + (n / 2)] + arr[start + (n / 2 - 1)]) / 2;
        } else {
            return arr[start + n / 2];
        }
    }


    //Solution2:
  /* 1) Merge the two input arrays ar1[] and ar2[].
     2) Sort ar1[] and ar2[] respectively.
     3) The median will be the last element of ar1[] + the first
     element of ar2[] divided by 2. [(ar1[n-1] + ar2[0])/2].
    */
    /// This function returns median of ar1[] and ar2[]. Assumptions in this function:
    //    Both ar1[] and ar2[] are sorted arrays Both have n elements */
    public static int getMedian(int[] ar1, int[] ar2, int n) {
        int j = 0;
        int i = n - 1;
        while (ar1[i] > ar2[j] && j < n) {
            int temp = ar1[i];
            ar1[i] = ar2[j];
            ar2[j] = temp;
            i--;
            j++;
        }
        Arrays.sort(ar1);
        Arrays.sort(ar2);
        return (ar1[n - 1] + ar2[0]) / 2;
    }

    // Driver code
    public static void main(String[] args) {
        int[] ar1 = {1, 2, 8, 11, 15};
        int[] ar2 = {7, 9, 12, 14, 16};
        int n1 = ar1.length;
//        System.out.println("Median is " + getMedian(ar1, ar2, 0, 0, ar1.length - 1, ar2.length - 1));
        System.out.println(getMedian(ar1,ar2,n1));

    }
}
