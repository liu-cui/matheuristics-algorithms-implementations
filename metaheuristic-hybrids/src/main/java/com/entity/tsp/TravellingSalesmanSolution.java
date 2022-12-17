package com.entity.tsp;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liucui
 */
public class TravellingSalesmanSolution {
    private double bestCost;
    private List<Integer> bestTour;


    public TravellingSalesmanSolution(){
        this.bestCost = 0D;
        this.bestTour = new ArrayList<>();

    }
    public TravellingSalesmanSolution(double bestCost, List<Integer> bestTour){
        this.bestCost = bestCost;
        this.bestTour = bestTour;
    }


    public void setSequence(List<Integer> bestTour){
        this.bestTour = bestTour;
    }

    public List<Integer> getSequence() {
        return bestTour;
    }

    public void setBestCost(double bestCost){
        this.bestCost = bestCost;
    }

    public double getBestCost() {
        return bestCost;
    }

    @Override
    public String toString() {
        return "TravellingSalesmanSolution{" +
                "cost=" + bestCost +
                ", bestTour=" + bestTour +
                '}';
    }
}
