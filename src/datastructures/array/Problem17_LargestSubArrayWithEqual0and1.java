package com.learning.dsa._2.array;

import java.util.HashMap;
import java.util.Map;

public class Problem17_LargestSubArrayWithEqual0and1 {
    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 0, 0, 1, 0};
        System.out.println(findMaxLength2(arr));
    }

    public static int findMaxLength(int[] nums) {
        int maxLen = 0;
        for (int start = 0; start < nums.length; start++) {
            int zeroes = 0, ones = 0;
            for (int end = start; end < nums.length; end++) {
                if (nums[end] == 0) {
                    zeroes++;
                } else {
                    ones++;
                }
                if (zeroes == ones) {
                    maxLen = Math.max(maxLen, end - start + 1);
                }
            }
        }
        return maxLen;
    }

    public static int findMaxLength2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int maxLen = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            //if num is 0 decrement count, if num is 1 increment count
            if (nums[i] == 0) {
                count -= 1;
            } else {
                count += 1;
            }
            if (map.containsKey(count)) {
                maxLen = Math.max(maxLen, i - map.get(count));
            } else {
                map.put(count, i);
            }
        }
        return maxLen;
    }
}
