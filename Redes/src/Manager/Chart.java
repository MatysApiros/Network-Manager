package Manager;

import java.util.ArrayList;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class Chart {

	public CategoryDataset createDataset (ArrayList<Double> oidsValues) {
		
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		
		for (int i = 0;  i < oidsValues.size(); i++) {
			
			String s = String.valueOf(i);
			
			dataset.addValue(oidsValues.get(i), "", s);
		}
		
		return dataset;
	}
	
	public JFreeChart createOIDChart (CategoryDataset dataset, String oidName) {
		
		JFreeChart barChart = ChartFactory.createLineChart(oidName, "OID Value", "Values", dataset, PlotOrientation.VERTICAL, false, false, false);
		
		return barChart;
	}
	
	public ChartPanel createChart (ArrayList<Double> oidsValues, String oidName) {
		
		CategoryDataset dataset = this.createDataset(oidsValues);
		
		JFreeChart chart = this.createOIDChart(dataset, oidName);
		
		ChartPanel chartPanel = new ChartPanel(chart);
		
		return chartPanel;
	}
}
