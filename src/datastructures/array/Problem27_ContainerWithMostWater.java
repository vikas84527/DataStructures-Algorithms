package com.learning.dsa._2.array;

public class Problem27_ContainerWithMostWater {

    //naive
    public static int maxArea(int[] a) {
        int maxArea = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                maxArea = Math.max(maxArea, Math.min(a[i], a[j]) * (j - i));
            }
        }
        return maxArea;
    }

    private static void containerWithMostWater(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        int area = 0;
        while (start < end) {
            area = Math.max(area, (end - start) * Math.min(arr[start], arr[end]));
            if (arr[start] < arr[end]) {
                start++;
            } else {
                end--;
            }
        }
        System.out.println(area);
    }
}
