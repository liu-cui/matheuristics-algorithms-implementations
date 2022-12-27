package com.algorithm.impl;

import lombok.extern.slf4j.Slf4j;

/**
 * @author liucui
 * @date 2022/12/27 11:25
 */
@Slf4j
public class MultiplierAdjustmentSA {
    private static final int numCli = 8;
    private static final int numServ = 3;

    public static void main(String[] args) {
        log.info("hello nan");
        int[][] cost = createCost();
        int[][] req = createReq();
        int[] cap = createCap();
        int[][] x = createInitSolution();
        boolean flag = isFeasible(x, req, cap);
        int totalCost = calcCost(x, cost);


        log.info(String.valueOf(flag));
        log.info(String.valueOf(totalCost));

    }

    private static int calcCost(int[][] x, int[][] cost) {
        int s = 0;
        for (int i = 0; i < numServ; i++) {
            for (int j = 0; j < numCli; j++) {
                s += x[i][j] * cost[i][j];
            }
        }
        return s;
    }

    private static boolean isFeasible(int[][] x, int[][] req, int[] cap) {
        for (int i = 0; i < numServ; i++) {
            int q = 0;
            for (int j = 0; j < numCli; j++) {
                q += x[i][j] * req[i][j];
            }
            if(q > cap[i]){
                return false;
            }
        }
        return true;
    }


    private static int[][] createInitSolution() {
        return new int[][]{
                {1, 0, 0, 0, 1, 1, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0},
                {0, 1, 1, 0, 0, 0, 1, 1}
        };
    }

    private static int[] createCap() {
        return new int[]{160, 90, 70};
    }

    private static int[][] createReq() {
        return new int[][]{
                {48, 47, 46, 45, 44, 43, 42, 41},
                {38, 37, 36, 35, 34, 33, 32, 31},
                {28, 27, 26, 25, 24, 23, 22, 21}};
    }

    private static int[][] createCost() {
        return new int[][]{
                {226, 227, 228, 229, 230, 231, 232, 233},
                {237, 239, 241, 243, 245, 247, 249, 251},
                {236, 240, 244, 248, 252, 256, 260, 264}};
    }

}
