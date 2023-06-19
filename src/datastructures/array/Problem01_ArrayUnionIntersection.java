package com.learning.dsa._2.array.hashing;

import java.util.HashSet;
import java.util.Set;

public class Problem01_ArrayUnionIntersection {
    public static void main(String[] args) {
        int[] arr1 = new int[]{5, 1, 5, 10, 9, 15, 20};
        int[] arr2 = new int[]{1, 5, 8, 5};
        System.out.println(CountIntersection(arr1, arr2));
    }
    static int CountIntersection(int[] arr1, int[] arr2) {
        int res = 0;
        Set<Integer> set = new HashSet<>();
        for (int elem : arr1) {
            set.add(elem);
        }
        for (int elem : arr2) {
            if (set.contains(elem)) {
                res++;
                set.remove(elem);
            }
        }
        return res;
    }

    static int CountUnion(int[] arr1, int[] arr2) {
        Set<Integer> set = new HashSet<>();
        for (int elem : arr1) {
            set.add(elem);
        }
        for (int elem : arr2) {
            set.add(elem);
        }
        return set.size();
    }

}
