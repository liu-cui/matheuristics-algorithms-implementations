package com.strategy;

import com.convert.TravellingSalesmanProblemConverter;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * @author liucui
 */
@Slf4j
public class BaseStrategy {
    private List<Integer> sequence;
    public List<Integer> process(String sourceType){
        log.info("process problem");
        new TravellingSalesmanProblemConverter().convert(sourceType);
//        sequence = new SimulatedAnnealing().solve(problem);
        log.info("tsp problem: {}");
        return null;
    }
}
