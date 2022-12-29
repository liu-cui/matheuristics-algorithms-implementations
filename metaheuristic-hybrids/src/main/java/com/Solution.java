package com;

import java.util.*;

class Solution {

    static void reverseArray(int[] array) {
        int size = array.length;
        int start = new Random().nextInt(size / 2);
        int end = new Random().nextInt(size);
        while (start >= end) {
            end = new Random().nextInt(size);
        }
        int n = end + start;
        for (int j = start; j < start + (end - start) / 2 + 1; j++) {
            int temp = array[j];
            array[j] = array[n - j];
            array[n - j] = temp;
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6};
        reverseArray(array);
    }
}
