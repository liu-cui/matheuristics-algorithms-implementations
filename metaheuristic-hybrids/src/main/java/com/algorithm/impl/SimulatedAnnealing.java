package com.algorithm.impl;

import com.algorithm.Solver;
import com.common.parameter.SimulatedAnnealingParameter;
import com.common.util.Util;
import com.entity.tsp.City;
import com.entity.tsp.TravellingSalesmanProblem;
import com.entity.tsp.TravellingSalesmanSolution;
import com.plot.PlotTour;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * @author liucui
 */
@Slf4j
public class SimulatedAnnealing implements Solver {
    @Override
    public TravellingSalesmanSolution solve(TravellingSalesmanProblem problem) {
        TravellingSalesmanSolution solution = new TravellingSalesmanSolution();
        int[] sequence = init(problem);
        int[] bestSequence = optimize(sequence, problem);
        double cost = cost(bestSequence, problem);
        List<Integer> collect = Arrays.stream(bestSequence).boxed().collect(Collectors.toList());
        solution.setSequence(collect);
        solution.setBestCost(cost);
        return solution;
    }


    private int[] optimize(int[] sequence, TravellingSalesmanProblem problem) {
        int[] bestSequence = copySequence(sequence);
        int[] currentSequence = copySequence(sequence);
        double bestCost = 0D;
        List<Double> costList = new ArrayList<>();
        List<String> iterList = new ArrayList<>();
        double t = SimulatedAnnealingParameter.TEMPERATURE_START;
        double tK = SimulatedAnnealingParameter.TEMPERATURE_END;
        double ratio = SimulatedAnnealingParameter.COOL_RATE;
        double iteration = SimulatedAnnealingParameter.ITERATION;
        Random random = new Random();
        int iter = 0;
        while (t > tK) {
            for (int i = 0; i < iteration; i++) {
                int[] updateSequence = swap(currentSequence);
                double curCost = cost(currentSequence, problem);
                double updateCost = cost(updateSequence, problem);
                if (acceptProbability(curCost, updateCost, t) >= random.nextDouble()) {
                    bestSequence = updateSequence;
                    currentSequence = updateSequence;
                    bestCost = cost(bestSequence, problem);

                }
            }
            iter++;
            t *= (1 - ratio);

            costList.add(bestCost);
            iterList.add(String.valueOf(iter));
        }
        PlotTour plotTour = new PlotTour();
        plotTour.plot(costList, iterList);
        return bestSequence;
    }

    private double acceptProbability(double curCost, double updateCost, double t) {
        double probability = Math.exp(-(updateCost - curCost) / t);
        return updateCost < curCost ? 1 : probability;
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
