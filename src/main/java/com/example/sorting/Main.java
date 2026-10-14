package com.example.sorting;

public class Main {

    public static void mergeSort(int[] a) {
        mergeSort(a, 0, a.length, new int[a.length]);
    }

    private static void mergeSort(int[] a, int left, int right, int[] buffer) {
        if (right - left <= 1) return;
        int middle = left + (right - left) / 2;
        mergeSort(a, left, middle, buffer);
        mergeSort(a, middle, right, buffer);
        int i = left, j = middle, k = left;
        while (i < middle && j < right) {
            if (a[i] <= a[j]) buffer[k++] = a[i++];
            else buffer[k++] = a[j++];
        }
        while (i < middle) buffer[k++] = a[i++];
        while (j < right) buffer[k++] = a[j++];
        System.arraycopy(buffer, left, a, left, right - left);
    }

    public static void main(String[] args) {
    }
}
