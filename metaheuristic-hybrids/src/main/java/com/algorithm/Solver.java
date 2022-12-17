package com.algorithm;

import com.entity.tsp.model.TravellingSalesmanProblem;

public interface Solver {
    int[] solve(TravellingSalesmanProblem travellingSalesmanProblem);
}
