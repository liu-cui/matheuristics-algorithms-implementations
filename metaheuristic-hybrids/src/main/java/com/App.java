package com;

import com.common.enums.SourceTypeEnum;
import com.strategy.BaseStrategy;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App {
    public static void main(String[] args) {
        BaseStrategy strategy = new BaseStrategy();
        strategy.process(SourceTypeEnum.TSP_ATT_48.getName());
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

class Person implements Cloneable{
    String name;

    Person(){}

    Person(String name) {
        this.name = name;
    }

    void setName(String name) {
        this.name = name;
    }

    String getName() {
        return this.name;
    }

    @Override
    public Person clone() {
        Person p = null;
        try {
            p = (Person) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return p;
    }

}
