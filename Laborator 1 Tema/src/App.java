import org.jfree.ui.RefineryUtilities;

public class App {

	public static void main(String[] args) {
		IGenerator gen = new DefaultGenerator();
		Evaluator e = new Evaluator(gen, 100); 
		e.eval();
		
		 Chart chart = new Chart("test", gen);
		 chart.pack();
		 RefineryUtilities.centerFrameOnScreen( chart );
	      chart.setVisible(true);
	}
}
