package ck;

import com.intellij.psi.PsiClass;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

import javax.swing.*;
import java.awt.*;

public class CreateChart extends ApplicationFrame {
    CKReport report;
    PsiClass psiClass;
    String chartTitle;
    ChartPanel chartPanel;
    JFrame f;

    public CreateChart( String applicationTitle , String chartTitle, CKReport report, PsiClass psiClass) {
        super( applicationTitle );
        f = new JFrame(chartTitle);
        this.report = report;
        this.psiClass = psiClass;
        this.chartTitle = chartTitle;
        JFreeChart barChart = ChartFactory.createBarChart(
                chartTitle,
                "CK Metric",
                "CK Score",
                createDataset(),
                PlotOrientation.VERTICAL,
                false, true, false);

        chartPanel = new ChartPanel(barChart);
        ChartPanelDemo();
    }

    public void ChartPanelDemo() {
        f.setTitle(chartTitle);
        f.setLayout(new BorderLayout(0, 5));
        f.add(chartPanel, BorderLayout.CENTER);

        JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        f.add(panel, BorderLayout.SOUTH);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    private CategoryDataset createDataset( ) {
        final String loc = "LOC";
        final String lcom = "LCOM";
        final String wmc = "WMC";
        final String nom = "NOM";
        final String cbo = "CBO";
        final DefaultCategoryDataset dataset =
                new DefaultCategoryDataset( );

        for(CKNumber result : report.all()) {
            if(result.isError()) continue;

            if(result.getClassName().equals(psiClass.getName())) {
                dataset.addValue(result.getLoc(), loc, loc);
                dataset.addValue(result.getLcom(), lcom, lcom);
                dataset.addValue(result.getWmc(), wmc, wmc);
                dataset.addValue(result.getNom(), nom, nom);
                dataset.addValue(result.getCbo(), cbo, cbo);
            }
        }
        return dataset;
    }

    public void updateData(CKReport report) {
        String lastStr = "", newStr = " ";
        for(CKNumber result : this.report.all()) {
            if(result.isError()) continue;
            if(result.getClassName().equals(psiClass.getName())) {
                lastStr = result.toString();
            }
        }

        for(CKNumber result : report.all()) {
            if(result.isError()) continue;
            if(result.getClassName().equals(psiClass.getName())) {
                newStr = result.toString();
            }
        }

        if (!lastStr.equals(newStr)) {
            this.report = report;
            updateChart();
        }
    }

    private void updateChart() {
        DefaultCategoryDataset dcd = new DefaultCategoryDataset();

        JFreeChart jchart = ChartFactory.createBarChart(
                chartTitle,
                "CK Metric",
                "CK Score",
                createDataset(),
                PlotOrientation.VERTICAL,
                false, true, false);

        chartPanel = new ChartPanel(jchart);

        f.add(chartPanel, BorderLayout.CENTER);

        JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        f.add(panel, BorderLayout.SOUTH);
        f.pack();
    }
}

