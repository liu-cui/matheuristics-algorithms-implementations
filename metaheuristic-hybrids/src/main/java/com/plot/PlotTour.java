package com.plot;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liucui
 */
public class PlotTour {

    public void plot(List<Double> values, List<String> col){
        List<String> row = new ArrayList<>();
        for (int i = 0; i < col.size(); i++) {
            row.add("algo");
        }
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (int i = 0; i < col.size(); i++) {
            dataset.addValue(values.get(i), row.get(i), col.get(i));
        }
        JFreeChart chart = ChartFactory.createLineChart(
                "TSP Tour Cost",
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
