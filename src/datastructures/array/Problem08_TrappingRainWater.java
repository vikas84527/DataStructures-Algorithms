package com.learning.dsa._2.array;

public class Problem08_TrappingRainWater {
    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int trappedWater = trappedWaterOptimal(arr);
        System.out.println(trappedWater);
    }

    private static int trappedWater(int[] arr) {
        // for each element find max ele at left and max ele at right and then find min between them then subtract ele from min
        int res = 0;
        for (int i = 1; i < arr.length - 1; i++) {
            int leftMax = arr[i];
            for (int j = i - 1; j >= 0; j--) {
                leftMax = Math.max(leftMax, arr[j]);
            }
            int rightMax = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                rightMax = Math.max(rightMax, arr[j]);
            }
            res += Math.min(leftMax, rightMax) - arr[i];
        }
        return res;
    }

    private static int trappedWaterOptimal(int[] arr) {
        // for each element find max ele at left and max ele at right and then find min between them then subtract ele from min
        int[] LEFT = new int[arr.length];
        int[] RIGHT = new int[arr.length];
        int res = 0;
        LEFT[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            LEFT[i] = Math.max(LEFT[i - 1], arr[i]);
        }
        RIGHT[arr.length - 1] = arr[arr.length - 1];
        for (int i = arr.length - 2; i >= 0; i--) {
            RIGHT[i] = Math.max(RIGHT[i + 1], arr[i]);
        }
        for (int i = 0; i < arr.length; i++) {
            res += Math.min(LEFT[i], RIGHT[i]) - arr[i];
        }
        return res;
    }
}
