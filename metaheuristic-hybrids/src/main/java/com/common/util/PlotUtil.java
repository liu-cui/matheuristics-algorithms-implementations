package com.common.util;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.TextAnchor;

import java.awt.*;
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
            if(i%100==0){
                dataset.addValue(values.get(i), row.get(i), String.valueOf(i));
            }
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

        /*背景显示*/
        CategoryPlot plot = chart.getCategoryPlot();
        plot.setDomainGridlinesVisible(true);
        plot.setNoDataMessage("No DataSet To Show");

        /*数据轴显示*/
//        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
//        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
//        rangeAxis.setAutoRangeIncludesZero(true);
//        rangeAxis.setUpperMargin(0.020);
//        rangeAxis.setLabelAngle(Math.PI / 2.0);
//        rangeAxis.setAutoRange(true);


        /*显示数据标签*/
        LineAndShapeRenderer renderer = (LineAndShapeRenderer) plot.getRenderer();
        renderer.setBaseItemLabelsVisible(false);
        renderer.setSeriesPaint(0, Color.red);
        renderer.setBaseShapesFilled(true);
        renderer.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.OUTSIDE1, TextAnchor.BASELINE_LEFT));
        renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
    }
}
