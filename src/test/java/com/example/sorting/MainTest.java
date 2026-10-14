package com.example.sorting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class MainTest {

    @ParameterizedTest
    @MethodSource("sortSizes")
    void testMergeSort(int n) {
        int[] arr = reverseSortedArray(n);

        long start = System.nanoTime();
        Main.mergeSort(arr);
        long diff = System.nanoTime() - start;
        System.out.println(diff);

        assertSorted(arr);
    }

    private static int[] reverseSortedArray(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = n - i + 1;
        return arr;
    }

    private static void assertSorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            Assertions.assertTrue(arr[i] <= arr[i + 1]);
        }
    }

    static Stream<Arguments> sortSizes() {
        return Stream.of(
                Arguments.of(10),
                Arguments.of(10),
                Arguments.of(100),
                Arguments.of(200),
                Arguments.of(400),
                Arguments.of(800),
                Arguments.of(1600),
                Arguments.of(3200),
                Arguments.of(6400),
                Arguments.of(12800),
                Arguments.of(25600),
                Arguments.of(51200),
                Arguments.of(102400)
        );
    }
}
