package com.example.sorting;

import java.util.Arrays;
import java.util.Random;

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

    // 0 - худший случай, 1 - лучший, 2 - средний
    static int[] makeArray(int n, int type) {
        int[] arr = new int[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            if (type == 0) arr[i] = n - i;
            else if (type == 1) arr[i] = i;
            else arr[i] = random.nextInt(n);
        }
        return arr;
    }

    static void test(String name, int type, boolean builtin) {
        int[] sizes = {10, 10, 100, 200, 400, 800, 1600, 3200, 6400, 12800, 25600, 51200, 102400};
        System.out.println(name);
        for (int n : sizes) {
            System.out.print(n);
            for (int k = 0; k < 5; k++) {
                int[] arr = makeArray(n, type);
                long start = System.nanoTime();
                if (builtin) Arrays.sort(arr);
                else mergeSort(arr);
                long diff = System.nanoTime() - start;
                System.out.print("\t" + diff);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        test("mergeSort, худший случай", 0, false);
        test("mergeSort, лучший случай", 1, false);
        test("mergeSort, средний случай", 2, false);

        test("Arrays.sort, худший случай", 0, true);
        test("Arrays.sort, лучший случай", 1, true);
        test("Arrays.sort, средний случай", 2, true);
    }
}
