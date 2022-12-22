package com.algorithm;

import com.entity.tsp.TravellingSalesmanProblem;
import com.entity.tsp.Tour;

public interface Solver {
    Tour solve(TravellingSalesmanProblem travellingSalesmanProblem);
}
