package com.common.util;

import java.util.Arrays;
import java.util.Random;

/**
 * @author liucui
 */
public class OperatorUtil {
    public double distance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }

    public double acceptProbability(double f1, double f2, double t) {
        double probability = Math.exp(-(f2 - f1) / t);
        return f2 < f1 ? 1 : probability;
    }

    public int[] exchange(int[] sequence) {
        Random random = new Random();
        int size = sequence.length;
        int p1 = random.nextInt(size);
        int p2 = random.nextInt(size);
        while (p1 == p2) {
            p2 = random.nextInt(size);
        }
        int[] copyArray = copySequence(sequence);
        int tmp = copyArray[p1];
        copyArray[p1] = copyArray[p2];
        copyArray[p2] = tmp;
        return copyArray;
    }


    public int[] reverse(int[] sequence) {
        int size = sequence.length;
        int start = new Random().nextInt(size / 2);
        int end = new Random().nextInt(size);
        while (start >= end) {
            end = new Random().nextInt(size);
        }
        int n = end + start;
        int[] copyArray = copySequence(sequence);
        for (int j = start; j < start + (end - start) / 2 + 1; j++) {
            int temp = copyArray[j];
            copyArray[j] = copyArray[n - j];
            copyArray[n - j] = temp;
        }
        return copyArray;
    }


    @Deprecated
    public int[] insert(int[] sequence) {
        int size = sequence.length;
        int p1 = new Random().nextInt(size);
        int p2 = new Random().nextInt(size);
        while (p1 >= p2) {
            p2 = new Random().nextInt(size);
        }
        int before = sequence[p1];
        int after = sequence[p2];
        int[] copyArray = new int[size];
        for (int i = 0; i < p1; i++) {
            copyArray[i] = sequence[i];
        }
        for (int i = p1; i < p2; i++) {
            copyArray[i] = sequence[i + 1];
        }
        for (int i = p2 + 1; i < size; i++) {
            copyArray[i] = sequence[i];
        }
        copyArray[p2] = before;

        return copyArray;
    }


    public int[] copySequence(int[] sequence) {
        int[] out = new int[sequence.length];
        System.arraycopy(sequence, 0, out, 0, sequence.length);
        return out;
    }
}
