package com;

import com.common.enums.SourceTypeEnum;
import com.entity.tsp.TravellingSalesmanSolution;
import com.strategy.BaseStrategy;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * @author liucui
 */
@Slf4j
public class App {

    public static void main(String[] args) throws IOException {
        usage();

/*        List<String> sourceTypeList = Arrays.stream(SourceTypeEnum.values()).map(SourceTypeEnum::getName).collect(Collectors.toList());
        for(String sourceType: sourceTypeList){
            TravellingSalesmanSolution solution = new BaseStrategy().process(sourceType);
            log.info("{} Tour", SourceTypeEnum.getEnumByName(sourceType));
            log.info("\t\tdistance: {}", solution.getBestCost());
            log.info("\t\ttour: {}", solution.getSequence());
        }*/

        String sourceType = SourceTypeEnum.TSP_ATT_48.getName();
        TravellingSalesmanSolution solution = new BaseStrategy().process(sourceType);
        log.info("{} Tour", SourceTypeEnum.getEnumByName(sourceType));
        log.info("\t\tdistance: {}", solution.getBestCost());
        log.info("\t\ttour: {}", solution.getSequence());
    }


    static void usage() {
        for (final String line : new String[]{
                "Usage: Through [SourceTypeEnum] To Solve Problem: TSP, TSPTW, CVRP, VRPTW",
                "Where Can Find SourceTypeEnum",
                "   com/common/enums/SourceTypeEnum.java",
                "   Options are:",
                "   -a solve problem with Benders letting CPLEX do the decomposition",
                "   -b solve problem with Benders specifying a decomposition",
                "   -d solve problem without using decomposition (default)",
                " Exiting..."
        }) {
            log.warn(line);
        }
    }
}

