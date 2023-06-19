package com.learning.dsa._2.array;

import java.util.Arrays;

import static java.lang.Math.max;

class Problem01_EasyProblems {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};

        int newLen = removeDuplicates(arr);
        for (int i = 0; i < newLen; i++) {
            System.out.print(arr[i]);
        }

        System.out.println();

        secondLargest(arr);

        leftRotateByD(arr, 3);

        int[] arr2 = {1, 3, 0, 1, 9, 0, 0, 0, 3, 2, 1, 0};
        moveZerosToEnd2(arr2);

        int[] arr3 = {1, 2, 3, 4, 5, 6, 7};
        int[] arr4 = {2, 4, 5, 7, 8, 99};
        unionOfTwoSorted(arr3, arr4);
        intersectionOfTwoSorted(arr3, arr4);
        System.out.println();
        int[] arr5 = {0, 0, 1, 1, 0, 0, 1, 1, 1, 0};
        maxConsecutiveOne(arr5);
        maxConsecutiveOneNaive(arr5);
        maxConsecutiveOnesTwoPointer(arr5, arr5.length - 1);
        int[] arr6 = {1, 2, 3, 4, 5, 7, 8, 9, 10};
        findMissingNum(arr6);

    }

    private static int removeDuplicates(int[] arr) {
        int j = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] != arr[i + 1]) {
                arr[j++] = arr[i];
            }
        }
        arr[j++] = arr[arr.length - 1];
        return j;
    }

    private static void secondLargestNaive(int[] arr) {
        if (arr.length < 2) {
            System.out.println("invalid input");
        }
        Arrays.sort(arr);
        int largest = arr[arr.length - 1], secLargest = Integer.MIN_VALUE;

        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] < largest) {
                secLargest = arr[i];
                System.out.println(secLargest);
                return;
            }
        }
        System.out.println("sec largets doesn't exist");

    }

    private static void secondLargest(int[] arr) {
        if (arr.length == 0 || arr.length == 1) {
            System.out.println(0);
        }
        int largest = arr[0], secLargest = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > largest) {
                secLargest = largest;
                largest = arr[i];
            } else if (arr[i] < largest && arr[i] > secLargest) {
                secLargest = arr[i];
            }
        }
        System.out.println(secLargest);
    }

    private static void leftRotateByOne(int[] arr) {
        int temp = arr[0];
        int i;
        for (i = 0; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[i] = temp;
    }

    private static void leftRotateByD(int[] arr, int D) {
        for (int i = 0; i < D; i++) {
            leftRotateByOne(arr);
        }
        System.out.println(Arrays.toString(arr));
    }

    private static void moveZerosToEnd(int[] arr) {
        //0,1,3,0,1,9,0,0,0,3,2,1,0
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            if (arr[start] == 0) {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                end--;
            } else {
                start++;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    private static void moveZerosToEnd2(int[] arr) {
        //0,1,3,0,1,9,0,0,0,3,2,1,0
        int start = 0, end = arr.length - 1;
        while (true) {
            while (arr[start] != 0) {
                start++;
            }
            while (arr[end] == 0) {
                end--;
            }
            if (start >= end) {
                break;
            }
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }

    private static void unionOfTwoSorted(int[] arr1, int[] arr2) {

        int idx = 0;
        int n1 = arr1.length;
        int n2 = arr2.length;
        int i = 0, j = 0;
        int count = 0;
        int[] res = new int[n1 + n2];
        while (i < n1 && j < n2) {
            if (arr1[i] < arr2[j]) {
                res[idx++] = arr1[i];
                i++;
            } else if (arr1[i] > arr2[j]) {
                res[idx++] = arr2[j];
                j++;
            } else {
                res[idx++] = arr1[i];
                i++;
                j++;
            }
            count++;
        }
        while (i < n1) {
            res[idx++] = arr1[i];
            i++;
            count++;
        }
        while (j < n2) {
            res[idx++] = arr2[j];
            j++;
            count++;
        }
        System.out.println();
        for (int k = 0; k < count; k++) {
            System.out.print(res[k] + " ");
        }
    }

    private static void intersectionOfTwoSorted(int[] arr1, int[] arr2) {
        int idx = 0;
        int n1 = arr1.length;
        int n2 = arr2.length;
        int i = 0, j = 0;
        int count = 0;
        int[] res = new int[n1 + n2];
        while (i < n1 && j < n2) {
            if (arr1[i] < arr2[j]) {
                i++;
            } else if (arr1[i] > arr2[j]) {
                j++;
            } else {
                res[idx++] = arr1[i];
                i++;
                j++;
                count++;
            }
        }
        System.out.println();
        for (int k = 0; k < count; k++) {
            System.out.print(res[k] + " ");
        }
    }

    private static void maxConsecutiveOneNaive(int[] arr) {
        //{0,0,1,1,0,1,1,1,0}
        int maxLen = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            int count = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == 1) {
                    count++;
                    maxLen = max(maxLen, count);
                } else {
                    count = 0;
                }
            }
        }
        System.out.println(maxLen);
    }

    private static void maxConsecutiveOne(int[] arr) {
        //{0,0,1,1,0,1,1,1,0}
        int maxLen = 0;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                count = 0;
            } else {
                count++;
                maxLen = max(maxLen, count);
            }
        }
        System.out.println(maxLen);
    }

    public static void maxConsecutiveOnesTwoPointer(int[] arr, int n) {
        if (n == 0)
            System.out.println(0);
        int maxOneCount = 0;
        int leftEnd = 0;
        while (leftEnd < n) {
            if (arr[leftEnd] == 0) {
                leftEnd = leftEnd + 1;
            } else {
                int rightEnd = leftEnd;
                while (rightEnd < n - 1 && arr[rightEnd + 1] == 1) {
                    rightEnd = rightEnd + 1;
                }
                maxOneCount = max(maxOneCount, rightEnd - leftEnd + 1);
                leftEnd = rightEnd + 1;
            }
        }
        System.out.println(maxOneCount);
    }

    public static void findMissingNum(int[] arr) {
        //{1,2,3,5,6,7,8,9,10}
        // formula for sum of n natural nums: (N * ( N + 1)) / 2
        int sum = 0;
        int n = arr.length;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        System.out.println(sum - (n * (n + 1)) / 2);
    }


}
