import java.awt.Color;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicInteger;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;



public class Chart extends ApplicationFrame{

	private Map<Float, AtomicInteger> listOfNumbers;
	private IGenerator gen;
	
	public Chart(String title, IGenerator gen) {
		super(title);
		this.gen = gen;
		JFreeChart lineChart = ChartFactory.createLineChart(title, "Numbers", "No", createDataSet());
		
		
		CategoryPlot plot = lineChart.getCategoryPlot();
		
		plot.setBackgroundPaint(Color.WHITE);
	    plot.setOutlinePaint(null);
	    plot.setForegroundAlpha(0.8f);
	    plot.setRangeGridlinesVisible(true);
	    plot.setRangeGridlinePaint(Color.black);
	    	   
		
		ChartPanel chartPanel = new ChartPanel(lineChart);
		setContentPane(chartPanel);
		
		
	}

	private void createSubDivisions() {
		listOfNumbers = new LinkedHashMap<Float, AtomicInteger>();
		for(float i = 0; i < 10; i+= 1.0f) {
			listOfNumbers.put(i/10, new AtomicInteger(0));
		}
		
	}

	private CategoryDataset createDataSet() {
		createSubDivisions();
		generateNumbersHash();
		DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
		for (Entry<Float, AtomicInteger> entry : listOfNumbers.entrySet()) {
			if(entry.getValue().get() > 0)
			dataset.addValue(entry.getValue() , "linie", entry.getKey() + "");
		}
	      return dataset;
	}

	private void generateNumbersHash() {
		for(int i = 0; i < 1000; i++) {
			float number = gen.next();
			boolean isAdded = true;
			int j = 0;
			while(isAdded){
				int next = j + 1;
				if(number >= (float)j / 10 && number < (float)next / 10){
					System.out.println((float) j / 10);
					System.out.println(number);
					listOfNumbers.get((float) j / 10).incrementAndGet();
					isAdded = false;
				}
				j++;
			}
					//listOfNumbers.get(number).incrementAndGet();
					//System.out.println(listOfNumbers.get(number));			
			
//			float number = gen.next();
//			if (listOfNumbers.get(number) != null) {
//				listOfNumbers.get(number).incrementAndGet();
//			} else {
//				listOfNumbers.put(number, new AtomicInteger(1));
//			}
		}
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
