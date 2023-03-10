package com.strategy;

import com.algorithm.sa.SimulatedAnnealing;
import com.convert.TravellingSalesmanProblemConverter;
import com.entity.tsp.TravellingSalesmanProblem;
import com.entity.tsp.Tour;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * @author liucui
 */
@Slf4j
public class BaseStrategy {
    public Tour process(String sourceType) throws IOException {
        TravellingSalesmanProblem problem = new TravellingSalesmanProblemConverter().convert(sourceType);
        SimulatedAnnealing sa = new SimulatedAnnealing();
        return sa.solve(problem);
    }
}
