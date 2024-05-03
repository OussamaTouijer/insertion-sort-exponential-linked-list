package org.example;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.JFrame;

public class BarChart_AWT extends JFrame { // Changed ApplicationFrame to JFrame

    public BarChart_AWT(String applicationTitle, String chartTitle) {
        super(applicationTitle);
        JFreeChart barChart = ChartFactory.createBarChart(
                chartTitle,
                "Means",
                "TimeSort(ms)",
                createDataset(),
                PlotOrientation.VERTICAL,
                true, true, false);

        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new java.awt.Dimension(560, 367));
        setContentPane(chartPanel);
    }

    private CategoryDataset createDataset() {
        final String average = "average";
        final String best = "best";
        final String worst = "worst";
        final String f100 = "Size 100";
        final String f200 = "Size 200";
        final String f300 = "Size 500";
        final DefaultCategoryDataset dataset =
                new DefaultCategoryDataset();

        dataset.addValue(1.0, average, f100);
        dataset.addValue(3.0, average, f200);
        dataset.addValue(5.0, average, f300);
        dataset.addValue(1.0, average, f100);
        dataset.addValue(6.0, average, f200);
        dataset.addValue(3.0, average, f300);
        dataset.addValue(8.0, average, f100);
        dataset.addValue(8.0, average, f200);
        dataset.addValue(4.0, average, f300);

        dataset.addValue(5.0, best, f100);
        dataset.addValue(6.0, best, f200);
        dataset.addValue(10.0, best, f300);

        dataset.addValue(4.0, worst, f100);
        dataset.addValue(2.0, worst, f200);
        dataset.addValue(3.0, worst, f300);

        return dataset;
    }

    public static void main(String[] args) {
        BarChart_AWT chart = new BarChart_AWT("Dist Expo",
                "Execution Time Comparison");
        chart.pack();
        chart.setVisible(true);
    }
}
