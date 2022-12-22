package com.common.util;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author liucui
 */
public class Util {
    public Util(){}

    public double distance(double x1, double y1, double x2, double y2){
        return Math.sqrt(Math.pow(x1-x2, 2) + Math.pow(y1 - y2, 2));
    }

    public double acceptProbability(double f1, double f2, double t) {
        double probability = Math.exp(-(f2 - f1) / t);
        return f2 < f1 ? 1 : probability;
    }

    public int[] swap(int[] sequence) {
        Random random = new Random();
        int size = sequence.length;
        int p1 = random.nextInt(size);
        int p2 = random.nextInt(size);
        while (p1 == p2) {
            p2 = random.nextInt(size);
        }
        int[] exchange = copySequence(sequence);
        int tmp = exchange[p1];
        exchange[p1] = exchange[p2];
        exchange[p2] = tmp;
        return exchange;
    }

    public int[] copySequence(int[] sequence) {
        int[] out = new int[sequence.length];
        System.arraycopy(sequence, 0, out, 0, sequence.length);
        return out;
    }

    public void plot(List<Double> values, String type){
        double v = values.stream().mapToDouble(Double::doubleValue).min().orElse(0D);
        List<String> row = new ArrayList<>();
        for (int i = 0; i < values.size(); i++) {
            row.add(type);
        }
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (int i = 0; i < values.size(); i++) {
            dataset.addValue(values.get(i), row.get(i), String.valueOf(i));
        }
        JFreeChart chart = ChartFactory.createLineChart(
                "TSP Tour Cost = " + v,
                "Iteration",
                "Cost",
                dataset,
                PlotOrientation.VERTICAL,
                true, true, true);
        ChartFrame chartFrame = new ChartFrame("Tour", chart);
        chartFrame.pack();
        chartFrame.setVisible(true);
    }
}
