package com.algorithm.impl;

import com.algorithm.Solver;
import com.common.util.Util;
import com.entity.tsp.model.City;
import com.entity.tsp.model.TravellingSalesmanProblem;
import com.entity.tsp.parameter.SimulatedAnnealingParameter;

import java.util.Random;
/**
 * @author liucui
 */
public class SimulatedAnnealing implements Solver {
    @Override
    public int[] solve(TravellingSalesmanProblem problem) {
        int[] sequence = init(problem);
        return optimize(sequence, problem);
    }

    private int[] optimize(int[] sequence, TravellingSalesmanProblem problem) {
        int[] bestSequence = copySequence(sequence);
        int[] currentSequence = copySequence(sequence);
        double t = SimulatedAnnealingParameter.TEMPERATURE_START;
        double tK = SimulatedAnnealingParameter.TEMPERATURE_END;
        double ratio = SimulatedAnnealingParameter.COOL_RATE;
        double iteration = 20 * sequence.length;
        Random random = new Random();
        while (t > tK) {
            int iter = 0;
            while (iter < iteration) {
                int[] updateSequence = swap(currentSequence);
                double delta = cost(updateSequence, problem) - cost(currentSequence, problem);
                if (delta < 0) {
                    bestSequence = updateSequence;
                    currentSequence = updateSequence;
                } else {
                    double r = random.nextDouble();
                    double p = Math.exp(-delta / t);
                    if (p >= r) {
                        currentSequence = updateSequence;
                    }
                }
                iter++;
            }
            t *= ratio;
        }
        return bestSequence;
    }

    private int[] init(TravellingSalesmanProblem problem) {
        int size = problem.getCityList().size();
        int[] sequence = new int[size];
        for (int i = 0; i < size; i++) {
            sequence[i] = problem.getCityIdList().get(i);
        }
        return sequence;
    }

    private int[] swap(int[] sequence) {
        Random random = new Random();
        int size = sequence.length;
        int p1 = random.nextInt(size);
        int p2 = random.nextInt(size);
        while (p1 == p2) {
            p2 = random.nextInt(size);
        }
        int[] exchange = copySequence(sequence);
        int tmp = exchange[p1];
        exchange[p1] = exchange[p2];
        exchange[p2] = tmp;
        return exchange;
    }


    public int[] copySequence(int[] sequence) {
        int[] out = new int[sequence.length];
        System.arraycopy(sequence, 0, out, 0, sequence.length);
        return out;
    }

    private double cost(int[] sequence, TravellingSalesmanProblem problem) {
        Util util = new Util();
        int size = problem.getCityIdList().size();
        double cost = 0;
        for (int i = 0; i < size - 1; i++) {
            int index1 = sequence[i] - 1;
            int index2 = sequence[i + 1] - 1;
            City c1 = problem.getCityList().get(index1);
            City c2 = problem.getCityList().get(index2);
            double dist = util.calcDist(c1.getX(), c1.getY(), c2.getX(), c2.getY());
            cost += dist;
        }
        City firstCity = problem.getCityList().get(sequence[0] - 1);
        City lastCity = problem.getCityList().get(sequence[size - 1] - 1);
        cost += util.calcDist(firstCity.getX(), firstCity.getY(), lastCity.getX(), lastCity.getY());
        return cost;
    }
}
