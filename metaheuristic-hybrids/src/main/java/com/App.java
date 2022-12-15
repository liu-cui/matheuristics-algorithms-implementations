package com;

import com.common.enums.SourceTypeEnum;
import com.strategy.BaseStrategy;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class App {
    public static void main(String[] args) {
        log.info("hello world");
        String type = SourceTypeEnum.TSP_ATT_48.getName();
        log.info(type);
        List<Integer> solution = new BaseStrategy().process(type);
        log.info("solution: {}", solution);
    }



    static void usage() {
        for (final String line : new String[]{
                "Usage: java Facility [options] [inputfile]",
                " where",
                "   inputfile describe a capacitated facility location instance as in",
                "   ../../../examples/data/facility.dat. If no input file",
                "   is specified read the file in example/data directory.",
                "   Options are:",
                "   -a solve problem with Benders letting CPLEX do the decomposition",
                "   -b solve problem with Benders specifying a decomposition",
                "   -d solve problem without using decomposition (default)",
                " Exiting..."
        }) {
            System.err.println(line);
        }
    }

}
