package com.learning.dsa._2.array;


import java.util.HashMap;
import java.util.Map;

public class Problem09_MajorityElement {
    public static void main(String[] args) {
        int[] arr = {3, 3, 3, 2, 4, 3, 3, 4};
        System.out.println(majorityElementOptimal(arr));
    }

    //Optimal using Moore’s Voting Algorithm:
    private static int majorityElementOptimal(int[] arr) {
        //{3, 3, 3, 2, 4, 3, 3, 4}
        int count = 0, cand = -1;

        for (int i = 1; i < arr.length; i++) {
            if (count == 0) {
                cand = arr[i];
                count = 1;
            } else {
                if (arr[i] == cand) {
                    count++;
                } else {
                    count--;
                }
            }
        }
        count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == cand) {
                count++;
            }
        }
        if (count > arr.length / 2) {
            return cand;
        }
        return -1;

    }

    public int majorityElement(int[] nums) {
        int count = 0;
        int cand = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == cand) {
                count++;
            } else {
                count--;
            }
            if (count < 0) {
                cand = nums[i];
                count = 0;
            }
        }
        return cand;
    }


    private static int majorityElemNaive(int[] arr) {
        int count = 0;
        int i, j;
        for (i = 0; i < arr.length; i++) {
            for (j = 0; j < arr.length; j++) {
                if (arr[j] == arr[i]) {
                    count++;
                }
            }
            if (count > arr.length / 2) {
                return arr[i];
            }
        }
        return -1;
    }

    private static int majorityElemBetter(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int ele : arr) {
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        }
        for (int ele : map.keySet()) {
            if (map.get(ele) > arr.length / 2) {
                return ele;
            }
        }
        return -1;
    }
}
