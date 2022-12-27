package com.common.util;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liucui
 * @date 2022/12/27 18:54
 */

public class PlotUtil {
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
