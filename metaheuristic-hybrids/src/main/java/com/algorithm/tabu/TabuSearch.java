package com.algorithm.tabu;

import com.algorithm.Solver;
import com.entity.tsp.Tour;
import com.entity.tsp.TravellingSalesmanProblem;

public class TabuSearch implements Solver {
    @Override
    public Tour solve(TravellingSalesmanProblem travellingSalesmanProblem) {
        return null;
    }

    private int[] init(TravellingSalesmanProblem problem) {
        int size = problem.getCityList().size();
        int[] sequence = new int[size];
        for (int i = 0; i < size; i++) {
            sequence[i] = problem.getCityIdList().get(i);
        }
        return sequence;
    }
}
