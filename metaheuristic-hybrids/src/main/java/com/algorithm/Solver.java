package com.algorithm;

import com.entity.tsp.TravellingSalesmanProblem;
import com.entity.tsp.TravellingSalesmanSolution;

public interface Solver {
    TravellingSalesmanSolution solve(TravellingSalesmanProblem travellingSalesmanProblem);
}
