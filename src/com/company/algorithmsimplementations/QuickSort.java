package com.company.algorithmsimplementations;

public class QuickSort {
        public static void quickSort(int[] nums, int low, int high) {

            if (nums.length == 0) {
                return;
            }
            if (low >= high) {
                return;
            }

            int i = low;
            int j = high;
            int pivot = nums[low + (high - low) / 2];

            while (i <= j) {
                while (nums[i] < pivot) {
                    i++;
                }
                while (pivot < nums[j]) {
                    j--;
                }
                if (i <= j) {
                    swap(nums, i, j);
                    i++;
                    j--;
                }
            }
            if (low < j) {
                quickSort(nums, low, j);
            }
            if (high > i) {
                quickSort(nums, i, high);
            }
        }

        private static void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
}
