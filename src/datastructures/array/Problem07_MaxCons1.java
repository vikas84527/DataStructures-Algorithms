package com.learning.dsa._2.array.sliding_window;

public class Problem07_MaxCons1 {
    public static void main(String[] args) {
        int[] arr = {1, 1, 0, 1, 1, 1};
        int[] arr2 = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        System.out.println(maxConsOne(arr));
        System.out.println(maxConsOneFlipK(arr2, 2));
    }

    public static int maxConsOne(int[] arr) {
        int maxOne = 0;
        int oneCount = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                oneCount++;
                maxOne = Math.max(maxOne, oneCount);
            } else {
                oneCount = 0;
            }
        }
        return maxOne;
    }

    //Max Consecutive 1 if we can flip k Zeros. if 1 flip allowed put k=1
    public static int maxConsOneFlipK(int[] nums, int k) {
        int maxOne = 0;
        int zeroCount = 0;
        int start = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroCount++;
            }
            while (zeroCount > k) {
                if (nums[start] == 0) {
                    zeroCount--;
                }
                start++;
            }
            maxOne = Math.max(maxOne, i - start + 1);
        }
        return maxOne;
    }
}
