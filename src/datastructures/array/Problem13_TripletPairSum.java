package com.learning.dsa._2.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem13_TripletPairSum {
    public static void main(String[] args) {
        int[] arr = {60, 54, 76, 40, 700, 11, 2, 46, 79, 13};
        tripletSumNaive(arr, 90);
    }

    private static void tripletSumNaive(int[] arr, int target) {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 2; i++) {
            int left = i + 1;
            int right = arr.length - 1;
            while (left < right) {
                if (arr[i] + arr[left] + arr[right] == target) {
                    System.out.println(arr[i] + ":" + arr[left] + ":" + arr[right]);
                    return;
                } else if (arr[i] + arr[left] + arr[right] < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        System.out.println("triplet Not present");
    }

    //when solution set must not contain duplicate triplets.
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[left]);
                    temp.add(nums[right]);
                    result.add(temp);
                    left++;
                    right--;

                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }

                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }

                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }

            }
        }
        return result;

    }
}
