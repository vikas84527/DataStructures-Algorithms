package com.learning.dsa._2.array.sliding_window;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Problem04_SubarrayWithGivenSum {
    public static void print(int[] nums, int i, int j) {
        System.out.println(IntStream.range(i, j + 1).mapToObj(k -> nums[k]).collect(Collectors.toList()));
    }

    //count no of sub array with given sum LeetCode-560
    public int subarraySum(int[] nums, int k) {
        int sum = 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    public int subarraySum2(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int currSum = 0;
            for (int j = i; j < nums.length; j++) {
                currSum += nums[j];
                if (currSum == k) count++;
            }
        }
        return count;
    }

    //===========================================================

    public static boolean FindSubArray(int[] array, int n, int K) {
        int sum = array[0];
        int start = 0;
        for (int i = 1; i <= n; i++) {
            while (sum > K && start < i - 1) {
                sum = sum - array[start];
                start++;
            }
            if (sum == K) {
                return true;
            }
            if (i < n) {
                sum = sum + array[i];
            }
        }
        return false;
    }


    // Function to find subarrays with the given sum in an array
    public static void findSubarrays(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            int sum_so_far = 0;

            // consider all subarrays starting from `i` and ending at `j`
            for (int j = i; j < nums.length; j++) {
                // sum of elements so far
                sum_so_far += nums[j];

                // if the sum so far is equal to the given sum
                if (sum_so_far == target) {
                    print(nums, i, j);
                    return;
                }
            }
        }
    }

    // Utility function to insert <key, value> pair into the multimap
    private static <K, V> void insert(Map<K, List<V>> hashMap, K key, V value) {
        // if the key is seen for the first time, initialize the list
        hashMap.putIfAbsent(key, new ArrayList<>());
        hashMap.get(key).add(value);
    }

    // Function to find subarrays with the given sum in an array
    public static void printAllSubarrays(int[] nums, int target) {
        // create a map for storing the end index of all subarrays with the sum of elements so far
        Map<Integer, List<Integer>> hashMap = new HashMap<>();
        // To handle the case when the subarray with the given sum starts from the 0th index
        insert(hashMap, 0, -1);
        int sum_so_far = 0;
        // traverse the given array
        for (int index = 0; index < nums.length; index++) {
            sum_so_far += nums[index];
            // check if there exists at least one subarray with the given sum
            if (hashMap.containsKey(sum_so_far - target)) {
                List<Integer> list = hashMap.get(sum_so_far - target);
                for (Integer value : list) {
                    print(nums, value + 1, index);
                }
            }

            // insert (target so far, current index) pair into the map
            insert(hashMap, sum_so_far, index);
        }
    }

    static int subarray(int[] arr, int n, int sum) {
        int currentsum = arr[0], start = 0, end;
        // Always start with the initial index of an array
        for (end = 1; end <= n; end++) {
            // If current sum exceeds the sum, then remove the starting elements
            while (currentsum > sum && sum < end - 1) {
                currentsum = currentsum - arr[start];
                start++;
            }
            // If currentsum becomes equal to sum, then return true
            if (currentsum == sum) {
                int p = end - 1;
                System.out.println("Subarray with given sum is between indexes " + start + " and " + p);
                return 1;
            }
            // Add this element to currentsum
            if (end < n) currentsum = currentsum + arr[end];
        }

        System.out.println("Subarray with given sum is NOT Found");
        return 0;
    }

    public static void main(String[] args) {
        int[] nums = {3, 4, -7, 1, 3, 3, 1, -4};
        int target = 7;

        findSubarrays(nums, target);
    }
}
