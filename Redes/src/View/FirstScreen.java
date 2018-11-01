package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Manager.Chart;

public class FirstScreen extends JFrame {

	private JPanel contentPane;

	public FirstScreen() {}
	
	public void addChartPanel(Chart chart, ArrayList<Double> oidsValues, String oidName) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel jPanelChart = new JPanel();
		contentPane.add(jPanelChart, BorderLayout.CENTER);
		
		jPanelChart.add(chart.createChart(oidsValues, oidName));
	}

}
