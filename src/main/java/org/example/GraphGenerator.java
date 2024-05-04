package org.example;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.util.Map;

public class GraphGenerator {

    public static void displayChart(Map<String, Schedule> data) {
        // Create a dataset
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (Map.Entry<String, Schedule> entry : data.entrySet()) {
            String key = entry.getKey();
            Schedule schedule = entry.getValue();

            // Add the data to the dataset (keeping in nanoseconds)
            dataset.addValue(schedule.getBestTime(), "Best Time", key);
            dataset.addValue(schedule.getAverageTime(), "Average Time", key);
            dataset.addValue(schedule.getWorstTime(), "Worst Time", key);
        }

        // Create the chart
        JFreeChart barChart = ChartFactory.createBarChart(
                "Sorting Execution Times", // Chart title
                "Data Size",               // Domain axis label
                "Time (ns)",               // Range axis label (changed to nanoseconds)
                dataset,                   // Dataset
                PlotOrientation.VERTICAL,  // Orientation
                true,                      // Include legend
                true,                      // Tooltips
                false);                    // URLs

        // Adjust the range axis to display nanoseconds
        NumberAxis rangeAxis = (NumberAxis) barChart.getCategoryPlot().getRangeAxis();
        rangeAxis.setAutoRangeIncludesZero(false); // Ensure zero is not included in the range
        rangeAxis.setNumberFormatOverride(new java.text.DecimalFormat("#.##E0")); // Scientific notation format for nanoseconds
        // You can adjust axis settings further as needed

        // Display the chart
        JFrame frame = new JFrame();
        frame.setContentPane(new ChartPanel(barChart));
        frame.setTitle("Execution Time Benchmark");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
