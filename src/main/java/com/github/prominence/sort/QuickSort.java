package com.github.prominence.sort;

public class QuickSort {

    public static void sort(int[] array) {
        int startIndex = 0;
        int endIndex = array.length - 1;
        quickSort(array, startIndex, endIndex);
    }

    private static void quickSort(int[] array, int start, int end) {
        if (start >= end) return;
        int i = start, j = end;
        int cur = i - (i - j) / 2;
        while (i < j) {
            while (i < cur && (array[i] <= array[cur])) {
                i++;
            }
            while (j > cur && (array[cur] <= array[j])) {
                j--;
            }
            if (i < j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                if (i == cur) {
                    cur = j;
                } else if (j == cur) {
                    cur = i;
                }
            }
        }
        quickSort(array, start, cur);
        quickSort(array, cur+1, end);
    }
}
