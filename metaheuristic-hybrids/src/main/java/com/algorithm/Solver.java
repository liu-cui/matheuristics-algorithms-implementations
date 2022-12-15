package com.algorithm;

import com.entity.tsp.model.TravellingSalesmanProblem;

import java.util.List;

public interface Solver {
    List<Integer> solve(TravellingSalesmanProblem travellingSalesmanProblem);
}
