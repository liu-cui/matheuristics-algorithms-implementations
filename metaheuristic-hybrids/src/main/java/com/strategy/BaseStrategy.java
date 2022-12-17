package com.strategy;

import com.algorithm.impl.SimulatedAnnealing;
import com.convert.TravellingSalesmanProblemConverter;
import com.entity.tsp.model.TravellingSalesmanProblem;
import lombok.extern.slf4j.Slf4j;

/**
 * @author liucui
 */
@Slf4j
public class BaseStrategy {
    public int[] process(String sourceType){
        TravellingSalesmanProblem problem = new TravellingSalesmanProblemConverter().convert(sourceType);
        int[] solution = new SimulatedAnnealing().solve(problem);
        return solution;
    }
}
