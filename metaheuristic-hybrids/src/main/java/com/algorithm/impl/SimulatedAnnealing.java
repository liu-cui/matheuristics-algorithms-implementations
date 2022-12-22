package com.algorithm.impl;

import com.algorithm.Solver;
import com.common.parameter.SimulatedAnnealingParameter;
import com.common.util.Util;
import com.entity.tsp.City;
import com.entity.tsp.Tour;
import com.entity.tsp.TravellingSalesmanProblem;
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
    public Tour solve(TravellingSalesmanProblem problem) {
        Tour solution = new Tour();
        int[] sequence = init(problem);
        int[] bestSequence = optimize(sequence, problem);
        double cost = cost(bestSequence, problem);
        List<Integer> collect = Arrays.stream(bestSequence).boxed().collect(Collectors.toList());
        solution.setTour(collect);
        solution.setBestCost(cost);
        return solution;
    }


    private int[] optimize(int[] sequence, TravellingSalesmanProblem problem) {
        Util util = new Util();
        int[] bestSequence = util.copySequence(sequence);
        int[] currentSequence = util.copySequence(sequence);
        double bestCost = 0D;
        List<Double> costList = new ArrayList<>();
        double t = SimulatedAnnealingParameter.TEMPERATURE_START;
        double tK = SimulatedAnnealingParameter.TEMPERATURE_END;
        double ratio = SimulatedAnnealingParameter.COOL_RATE;
        double iteration = SimulatedAnnealingParameter.ITERATION;
        Random random = new Random();
        int iter = 0;
        while (t > tK) {
            for (int i = 0; i < iteration; i++) {
                int[] updatedSequence = util.swap(currentSequence);
                double curCost = cost(currentSequence, problem);
                double updateCost = cost(updatedSequence, problem);
                if (util.acceptProbability(curCost, updateCost, t) >= random.nextDouble()) {
                    bestSequence = updatedSequence;
                    currentSequence = updatedSequence;
                    bestCost = cost(bestSequence, problem);
                }
            }
            iter++;
            t *= (1 - ratio);
            costList.add(bestCost);
        }
        log.info("Simulated Annealing Iteration: {}", iter);
        log.info("Simulated Annealing Temperature {}", t);
        util.plot(costList, problem.getType());
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

    private double cost(int[] sequence, TravellingSalesmanProblem problem) {
        Util util = new Util();
        int size = problem.getCityIdList().size();
        double cost = 0;
        for (int i = 0; i < size - 1; i++) {
            int index1 = sequence[i] - 1;
            int index2 = sequence[i + 1] - 1;
            City c1 = problem.getCityList().get(index1);
            City c2 = problem.getCityList().get(index2);
            double dist = util.distance(c1.getX(), c1.getY(), c2.getX(), c2.getY());
            cost += dist;
        }
        City firstCity = problem.getCityList().get(sequence[0] - 1);
        City lastCity = problem.getCityList().get(sequence[size - 1] - 1);
        cost += util.distance(firstCity.getX(), firstCity.getY(), lastCity.getX(), lastCity.getY());
        return cost;
    }
}
