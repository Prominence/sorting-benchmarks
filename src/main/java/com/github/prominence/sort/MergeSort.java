package com.github.prominence.sort;

public class MergeSort {

    public static void sort(int[] array) {
        int[] aux = new int[array.length];

        mergeSort(array, aux, 0, array.length);
    }

    private static void mergeSort(int[] array, int[] aux, int lo, int hi) {
        if (hi - lo <= 1) return;
        int mid = lo + (hi - lo) / 2;
        mergeSort(array, aux, lo, mid);
        mergeSort(array, aux, mid, hi);
        int i = lo;
        int j = mid;
        for (int k = lo; k < hi; k++) {
            if (i == mid) {
                aux[k] = array[j++];
            } else if (j == hi) {
                aux[k] = array[i++];
            } else if (array[j] < array[i]) {
                aux[k] = array[j++];
            } else {
                aux[k] = array[i++];
            }
        }
        System.arraycopy(aux, lo, array, lo, hi - lo);
    }
}
