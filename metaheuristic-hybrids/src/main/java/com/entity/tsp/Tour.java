package com.entity.tsp;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liucui
 */
public class Tour {
    private double bestCost;
    private List<Integer> bestTour;
    private List<Double> costList;

    public Tour() {
        this.bestCost = 0;
        this.bestTour = new ArrayList<>();
        this.costList = new ArrayList<>();
    }

    public Tour(double bestCost, List<Integer> bestTour, List<Double> costList) {
        this.bestCost = bestCost;
        this.bestTour = bestTour;
        this.costList = costList;
    }

    public void setTour(List<Integer> bestTour) {
        this.bestTour = bestTour;
    }

    public List<Integer> getTour() {
        return bestTour;
    }

    public void setBestCost(double bestCost) {
        this.bestCost = bestCost;
    }

    public double getBestCost() {
        return bestCost;
    }

    public void setCostList(List<Double> costList) {
        this.costList = costList;
    }

    public List<Double> getCostList() {
        return costList;
    }

    @Override
    public String toString() {
        return "Tour{" +
                "bestCost=" + bestCost +
                ", bestTour=" + bestTour +
                ", costList=" + costList +
                '}';
    }
}
