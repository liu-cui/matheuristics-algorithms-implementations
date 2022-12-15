package com.algorithm.impl;

import com.algorithm.Solver;
import com.entity.tsp.model.TravellingSalesmanProblem;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * @author liucui
 */
@Slf4j
public class SimulatedAnnealing implements Solver {

    @Override
    public List<Integer> solve(TravellingSalesmanProblem travellingSalesmanProblem) {
        log.info("apply sa algorithm");
        return null;
    }


}
