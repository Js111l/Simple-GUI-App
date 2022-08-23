package com.company.algorithmsimplementations;

public class MergeSort {
        public static void mergeSort(int[] array, int low, int high) {
            if (high <= low) {
                return;
            }
            int mid = (low + high) / 2;

            mergeSort(array, low, mid);
            mergeSort(array, mid + 1, high);
            merge(array, low, mid, high);
        }

        private static void merge(int[] array, int low, int mid, int high) {
            int[] leftArray = new int[mid - low + 1];
            int[] rightArray = new int[high - mid];

            System.arraycopy(array, 0 + low, leftArray, 0, leftArray.length);
            for (int i = 0; i < rightArray.length; i++) {
                rightArray[i] = array[i + mid + 1];
            }

            int i = 0;
            int j = 0;
            int index = low;

            while (i < leftArray.length && j < rightArray.length) {
                if (leftArray[i] < rightArray[j]) {
                    array[index] = leftArray[i];
                    index++;
                    i++;
                } else {
                    array[index] = rightArray[j];
                    j++;
                    index++;
                }

            }
            while (i < leftArray.length) {
                array[index] = leftArray[i];
                i++;
                index++;
            }
            while (j < rightArray.length) {
                array[index] = rightArray[j];
                j++;
                index++;
            }

        }
}
