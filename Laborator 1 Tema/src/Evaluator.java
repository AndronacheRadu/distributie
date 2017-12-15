
public class Evaluator {
	private final float pi = 3.14f;
	
	private IGenerator gen;
	
	private int nrOfNumbers;
	
	private int numberOfPoint;

	public Evaluator(IGenerator gen, int nrOfNumbers) {
		this.gen = gen;
		this.nrOfNumbers = nrOfNumbers;
	}
	
	public float eval(){
		numberOfPoint = 0;
		for(int i = 0; i < nrOfNumbers; i++){
			float x = gen.next();
			float y = gen.next();
			if(Math.pow(x, 2) + Math.pow(y, 2) <= 1){
				numberOfPoint++;
			}
		}
		float aux = (4*numberOfPoint)/nrOfNumbers;
		return (Math.abs(pi-aux));
	}
}
