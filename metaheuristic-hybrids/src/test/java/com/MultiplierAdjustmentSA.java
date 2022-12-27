package com;

import com.common.util.JsonUtil;
import com.entity.demo.Capacity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.test.context.SpringBootTest;

import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author liucui
 * @date 2022/12/27 11:25
 */
@Slf4j
@SpringBootTest
public class MultiplierAdjustmentSA {
    private static final int numCli = 8;
    private static final int numServ = 3;
    private static final String FILE_PATH_PREFIX = "metaheuristic-hybrids/src/test/resources/";

    public static void main(String[] args) throws Exception {
        log.info("hello nan");
        int[][] cost = createCost();
        int[][] req = createReq();
        int[] cap = createCap();
        int[][] x = createInitSolution();
        boolean flag = isFeasible(x, req, cap);
        int totalCost = calcCost(x, cost);

        String fileName = "example8x3.json";
        Capacity capacity = buildRequest(fileName);
        log.info("capacity: {}", capacity.getCap().get(0));

    }


    private static Capacity buildRequest(String fileName) throws Exception {
        String raw = new String(Files.readAllBytes(Paths.get(FILE_PATH_PREFIX, fileName)));
        return JsonUtil.toObject(raw, Capacity.class);
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
