package com.strategy;

import com.algorithm.impl.SimulatedAnnealing;
import com.convert.TravellingSalesmanProblemConverter;
import com.entity.tsp.TravellingSalesmanProblem;
import com.entity.tsp.TravellingSalesmanSolution;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * @author liucui
 */
@Slf4j
public class BaseStrategy {
    public TravellingSalesmanSolution process(String sourceType) throws IOException {
        TravellingSalesmanProblem problem = new TravellingSalesmanProblemConverter().convert(sourceType);
        SimulatedAnnealing sa = new SimulatedAnnealing();
        return sa.solve(problem);
    }
}
