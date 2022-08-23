package com.company.algorithmsimplementations;

public class BinarySearch {
        public static int binarySearch(int[] array, int low, int high, int k) {

            if (high >= low) {
                int mid = low + ((high - low) / 2);
                if (k == array[mid])
                    return mid;
                if (k < array[mid])
                    return binarySearch(array, low, mid - 1, k);
                else
                    return binarySearch(array, mid + 1, high, k);
            }
            return -1;
        }
        public static int interpolationSearch(int[] arr, int low, int high, int k) {

            if (arr[low] <= k && k <= arr[high] && low <= high) {
                int pos = low + (
                        ((k - arr[low]) * (high - low)) / (arr[high] - arr[low])
                );
                if (k == arr[pos])
                    return pos;
                if (k < arr[pos])
                    return interpolationSearch(arr, low, pos - 1, k);
                else
                    return interpolationSearch(arr, pos + 1, high, k);
            }
            return -1;
        }
}
